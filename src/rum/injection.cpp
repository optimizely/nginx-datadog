#include "injection.h"

extern "C" {
#include <ngx_core.h>
}

#include "datadog_conf.h"
#include "ngx_http_datadog_module.h"

ngx_http_output_header_filter_pt ngx_http_next_header_filter;
ngx_http_output_body_filter_pt ngx_http_next_body_filter;

namespace datadog {
namespace nginx {
namespace rum {
namespace {

ngx_int_t dd_validate_content_type(ngx_str_t *content_type) {
  static const ngx_str_t html_content_type = ngx_string("text/html");
  return content_type->len == html_content_type.len &&
         ngx_strncmp(content_type->data, html_content_type.data,
                     html_content_type.len) == 0;
}

// TODO: Add support for other `Content-Encoding`.
// More details: https://en.wikipedia.org/wiki/HTTP_compression
ngx_int_t dd_content_compressed(ngx_http_headers_out_t *headers) {
  return (headers->content_encoding != NULL &&
          headers->content_encoding->value.len != 4 &&
          ngx_strncasecmp(headers->content_encoding->value.data,
                          (u_char *)"gzip", 4) == 0);
}

ngx_int_t output(Context &ctx, ngx_http_request_t *r, ngx_chain_t *out,
                 ngx_http_output_body_filter_pt &next_body_filter) {
  ngx_int_t rc = next_body_filter(r, out);
  ngx_chain_update_chains(r->pool, &ctx.free, &ctx.busy, &out,
                          (ngx_buf_tag_t)&ngx_http_datadog_module);
  return rc;
}

ngx_chain_t *inject(Context &ctx, ngx_pool_t *pool, ngx_chain_t *in,
                    const BytesSlice *slices, uint32_t slices_length) {
  ngx_chain_t *out;
  ngx_chain_t **ll = &out;

  ngx_chain_t *cl = ngx_chain_get_free_buf(pool, &(ctx.free));
  if (cl == NULL) {
    /* TBD */
  }
  size_t needed = 0;
  for (uint32_t i = 0; i < slices_length; ++i) {
    needed += slices[i].length;
  }

  ngx_buf_t *buf = cl->buf;
  ngx_memzero(buf, sizeof(ngx_buf_t));
  buf->tag = (ngx_buf_tag_t)&ngx_http_datadog_module;
  buf->memory = 1;
  buf->recycled = 1;

  buf->start = (u_char *)ngx_pnalloc(pool, sizeof(char) * needed);
  buf->end = buf->start + needed;
  buf->pos = buf->start;
  buf->last = buf->pos;

  for (uint32_t i = 0; i < slices_length; ++i) {
    ngx_cpymem(buf->last, slices[i].start, slices[i].length);
    buf->last += slices[i].length;
  }

  // TODO: use `in` last_buffer and other thingy
  cl->next = in->next;

  *ll = cl;

  if (in->buf->recycled) {
    in->buf->pos = in->buf->last;
  }

  return out;
}

}  // namespace

ngx_int_t on_header_filter(ngx_http_request_t *r,
                           ngx_http_output_header_filter_pt &next_header_filter,
                           Context &ctx) {
  ngx_log_t *log = r->connection->log;
  ngx_log_debug1(NGX_LOG_DEBUG_HTTP, log, 0, "[rum][%V] on_header_filter start",
                 &(r->uri));

  auto *cfg = static_cast<datadog_loc_conf_t *>(
      ngx_http_get_module_loc_conf(r, ngx_http_datadog_module));
  if (cfg == NULL) return NGX_ERROR;

  if (!cfg->rum_enable || cfg->rum_snippet == NULL)
    return next_header_filter(r);

  if (r->header_only || r->headers_out.content_length_n == 0 ||
      dd_validate_content_type(&r->headers_out.content_type) == 0)
    return next_header_filter(r);

  if (dd_content_compressed(&r->headers_out)) {
    ngx_log_debug0(NGX_LOG_DEBUG_HTTP, log, 0,
                   "could not inject in compressed html content");
    return next_header_filter(r);
  }

  ctx.injected = 0;
  ctx.enabled = true;
  ctx.injector = injector_create(cfg->rum_snippet);

  // In case `Transfer-Encoding: chunk` is enabled no need to update the content
  // length.
  if (r->headers_out.content_length_n != -1) {
    ctx.output_padding = 1;
    r->headers_out.content_length_n += cfg->rum_snippet->length;
  } else {
    ctx.output_padding = 0;
  }

  // Set header now 'cause it will be too late after
  auto *h =
      static_cast<ngx_table_elt_t *>(ngx_list_push(&r->headers_out.headers));
  if (h == NULL) {
    return NGX_ERROR;
  }

  h->hash = 1;
  ngx_str_set(&h->key, "x-datadog-sdk-injected");
  ngx_str_set(&h->value, "1");

  // TODO: investigate `filter_need_temporary`.
  r->filter_need_in_memory = 1;
  // r->main_filter_need_in_memory = 1;

  ngx_log_debug1(NGX_LOG_DEBUG_HTTP, log, 0, "[rum][%V] on_header_filter end",
                 &(r->uri));
  return NGX_OK;
}

// TODO: lots of copy involved. A better implementation should only copy and
// insert the snippet.
ngx_int_t on_body_filter(ngx_http_request_t *r, ngx_chain_t *in,
                         ngx_http_output_body_filter_pt &next_body_filter,
                         Context &ctx) {
  ngx_log_t *log = r->connection->log;

  auto *cfg = static_cast<datadog_loc_conf_t *>(
      ngx_http_get_module_loc_conf(r, ngx_http_datadog_module));
  if (cfg == NULL) return NGX_ERROR;

  if (!cfg->rum_enable) return next_body_filter(r, in);

  if (in == NULL || ctx.enabled == false || ctx.injected == 1)
    return next_body_filter(r, in);

  ngx_chain_t *out;
  ngx_chain_t *lp = NULL;
  ngx_chain_t **ll = &out;
  InjectorResult result;

  for (ngx_chain_t *cl = in; cl; cl = cl->next) {
    lp = cl;

    result = injector_write(ctx.injector, (uint8_t *)cl->buf->pos,
                            (uint32_t)(cl->buf->last - cl->buf->pos));

    // TODO: It seems the `injector` always return something even if it did not
    // found an injection point. Not ideal.
    if (result.slices_length == 0) {
      *ll = cl;
      ll = &cl->next;
    } else {
      ngx_chain_t *new_cl =
          inject(ctx, r->pool, cl, result.slices, result.slices_length);

      *ll = new_cl;
      ll = &new_cl->next;

      if (result.injected) {
        ngx_log_debug1(NGX_LOG_DEBUG_HTTP, log, 0, "[rum][%V] on_body_filter 8",
                       &(r->uri));
        ctx.injected = result.injected;
        return output(ctx, r, out, next_body_filter);
      }
    }
  }

  // No need for padding -> no need to call `injector_end`.
  if (ctx.output_padding && lp->buf->last_buf) {
    result = injector_end(ctx.injector);

    *ll = inject(ctx, r->pool, lp, result.slices, result.slices_length);
  }

  return output(ctx, r, out, next_body_filter);
}

ngx_int_t on_rewrite_handler(ngx_http_request_t *r) {
  auto *cfg = static_cast<datadog_loc_conf_t *>(
      ngx_http_get_module_loc_conf(r, ngx_http_datadog_module));
  if (cfg == NULL) {
    // NOTE(@dmehala): error or declined? What's the implication of error here?
    return NGX_ERROR;
  }

  if (!cfg->rum_enable) {
    return NGX_DECLINED;
  }

  ngx_table_elt_t *h =
      static_cast<ngx_table_elt_t *>(ngx_list_push(&r->headers_in.headers));
  if (h == NULL) {
    return NGX_ERROR;
  }

  h->hash = 1;
  h->lowcase_key = (u_char *)"x-datadog-sdk-injection";
  ngx_str_set(&h->key, "x-datadog-sdk-injection");
  ngx_str_set(&h->value, "1");

  return NGX_DECLINED;
}

}  // namespace rum
}  // namespace nginx
}  // namespace datadog
