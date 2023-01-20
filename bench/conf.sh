
DELAY_MILLISECONDS=100

# export BASELINE_NGINX_TAG=1.23.1-alpine
BASELINE_BASE_IMAGE="nginx-datadog-build-$BASELINE_NGINX_TAG"
# export BASELINE_REPO='https://github.com/DataDog/nginx-datadog'
BASELINE_REVISION='david.goffredo/benchmarks'
BASELINE_NGINX_CONF=$(cat <<'END_CONF'
load_module modules/ngx_http_datadog_module.so;

error_log stderr info;

events {
  worker_connections  1024;
}

http {
  access_log /dev/null;

  server {
    listen 80;

    location / {
      proxy_pass http://baseline-upstream;
    }
  }
}
END_CONF
)

# export CONTROL_NGINX_TAG=$BASELINE_NGINX_TAG
CONTROL_BASE_IMAGE=$BASELINE_BASE_IMAGE
# export CONTROL_REPO=$BASELINE_REPO
CONTROL_REVISION=david.goffredo/dd-trace-cpp

# export TEST_NGINX_TAG=$BASELINE_NGINX_TAG
TEST_BASE_IMAGE=$BASELINE_BASE_IMAGE
# export TEST_REPO=$BASELINE_REPO
TEST_REVISION=david.goffredo/dd-trace-cpp-threaded-event-scheduler
