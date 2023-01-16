# The benchmark driver will source this file after first sourcing
# "./defaults.conf.sh".
#
# Here is where you override environment variables to configure your
# particular benchmark.
#
# See "./defaults.conf.sh" for what can be overridden.
#
# The shell language is that understood by "/bin/sh".  Please keep it POSIX.

BASELINE_REVISION=david.goffredo/benchmarks
CONTROL_REVISION=$BASELINE_REVISION
TEST_REVISION=$BASELINE_REVISION
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
