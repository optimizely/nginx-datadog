#!/bin/sh

set -e

if command -v apt-get >/dev/null 2>&1; then
    apt-get update
    # `procps` contains `kill`, which is used to bring down temporary instances
    # of nginx.
    # `pstack` is useful in debugging.
    DEBIAN_FRONTEND=noninteractive apt-get install -y procps pstack
elif command -v apk >/dev/null 2>&1; then
    apk update
    # `procps` contains `kill`, which is used to bring down temporary instances
    # of nginx.
    # `gdb` installs `pstack`, which is useful in debugging.
    apk add procps gdb
else
    >&2 printf 'Did not find a supported package manager.\n'
    exit 1
fi
