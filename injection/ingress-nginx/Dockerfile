# docker build -t damienmehala178/ingress-nginx-injection:v1.10.0 .
# docker push damienmehala178/ingress-nginx-injection:v1.10.0
#
# TODO:
#   - support amd64 and arm64
#   - hijack otel directives
#   - build instead of using pre-built? (use multi-stage dockerfile)
#   - add tests
#   - run shellcheck
FROM alpine:latest

ARG NGINX_VERSION
ARG ARCH

WORKDIR /datadog/

COPY init_module.sh .

ADD https://ddagent-windows-unstable.s3.amazonaws.com/inject-browser-sdk/nginx/7807ba/ngx_http_datadog_module-${ARCH}-${NGINX_VERSION}.so.tgz ngx_http_datadog_module.so.tgz

RUN tar xzf ngx_http_datadog_module.so.tgz \
 && rm ngx_http_datadog_module.so.tgz

RUN chmod +x init_module.sh \
 && cp init_module.sh /usr/local/bin/init_module.sh

