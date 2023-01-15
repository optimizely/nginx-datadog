arg BASE_IMAGE
from ${BASE_IMAGE}

entrypoint ["nginx"]
cmd ["-g", "daemon off;"]

arg REPO
arg REVISION
arg NGINX_TAG

workdir /usr/local/src/nginx-datadog
run set -x && \
    git init && \
    git remote add origin "${REPO}" && \
    git fetch --depth=1 origin "${REVISION}" && \
    git checkout origin/"${REVISION}" && \
    printf '%s' "${NGINX_TAG}" >nginx-tag && \
    make build && \
    cp .build/libngx_http_datadog_module.so /usr/lib/nginx/modules/ngx_http_datadog_module.so

arg NGINX_CONF
run printf '%s' "${NGINX_CONF}" >/etc/nginx/nginx.conf
