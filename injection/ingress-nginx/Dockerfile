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

WORKDIR /datadog/

COPY init_module.sh .

ADD https://github.com/DataDog/nginx-datadog/releases/download/v1.2.1/ngx_http_datadog_module-amd64-1.25.3.so.tgz ngx_http_datadog_module-amd64-1.25.3.so.tgz

RUN tar xzf ngx_http_datadog_module-amd64-1.25.3.so.tgz \
 && rm ngx_http_datadog_module-amd64-1.25.3.so.tgz

RUN chmod +x init_module.sh \
 && cp init_module.sh /usr/local/bin/init_module.sh

