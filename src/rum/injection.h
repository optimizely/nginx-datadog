#pragma once

extern "C" {
#include <ngx_http.h>
}
#include <injectbrowsersdk.h>

namespace datadog {
namespace nginx {
namespace rum {

struct Context {
  bool enabled{false};
  ngx_uint_t injected{0};
  ngx_uint_t output_padding;

  ngx_chain_t *busy{nullptr};
  ngx_chain_t *free{nullptr};

  Injector *injector{nullptr};
};

ngx_int_t on_header_filter(ngx_http_request_t *r,
                           ngx_http_output_header_filter_pt &next_header_filter,
                           Context &ctx);
ngx_int_t on_body_filter(ngx_http_request_t *r, ngx_chain_t *in,
                         ngx_http_output_body_filter_pt &next_body_filter,
                         Context &ctx);
ngx_int_t on_rewrite_handler(ngx_http_request_t *r);

}  // namespace rum
}  // namespace nginx
}  // namespace datadog
