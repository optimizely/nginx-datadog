
export REQUESTS_PER_SECOND=10

# Usually the baseline doesn't use tracing, and so the build of the
# nginx-datadog module doesn't matter.
# In general, though, the baseline might involve tracing, so the build of
# the module is configurable here.
export BASELINE_NGINX_TAG=1.23.1-alpine
export BASELINE_BASE_IMAGE="datadog/docker-library:nginx-datadog-build-$BASELINE_NGINX_TAG"
export BASELINE_REPO='https://github.com/DataDog/nginx-datadog'
export BASELINE_REVISION='master'
export BASELINE_NGINX_CONF=$(cat <<'END_CONF'
error_log stderr;

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

export CONTROL_NGINX_TAG=$BASELINE_NGINX_TAG
export CONTROL_BASE_IMAGE=$BASELINE_BASE_IMAGE
export CONTROL_REPO=$BASELINE_REPO
export CONTROL_REVISION=$BASELINE_REVISION
export CONTROL_NGINX_CONF=$(cat <<'END_CONF'
load_module modules/ngx_http_datadog_module.so;

error_log stderr;

events {
  worker_connections  1024;
}

http {
  access_log /dev/null;

  server {
    listen 80;

    location / {
      proxy_pass http://control-upstream;
    }
  }
}
END_CONF
)

export TEST_NGINX_TAG=$BASELINE_NGINX_TAG
export TEST_BASE_IMAGE=$BASELINE_BASE_IMAGE
export TEST_REPO=$BASELINE_REPO
export TEST_REVISION=$BASELINE_REVISION
export TEST_NGINX_CONF=$(cat <<'END_CONF'
load_module modules/ngx_http_datadog_module.so;

error_log stderr;

events {
  worker_connections  1024;
}

http {
  access_log /dev/null;

  server {
    listen 80;

    location / {
      proxy_pass http://test-upstream;
    }
  }
}
END_CONF
)
