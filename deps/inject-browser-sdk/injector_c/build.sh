#/bin/sh

set -euo pipefail

find_lib_path() {
  local targets=(debug release)
  local names=(libinjectbrowsersdk.dylib libinjectbrowsersdk.so)
  for target in "${targets[@]}"; do
    for name in "${names[@]}"; do
      local lib_path="$ROOT_DIR/lib/target/$target/$name"
      if [[ -e $lib_path ]]; then
        echo "$lib_path"
        return
      fi
    done
  done
  echo "Lib not found" > /dev/stderr
  exit 1
}

ROOT_DIR=$(git rev-parse --show-toplevel)
INJECTOR_DIR=$ROOT_DIR/injector_c
PLATFORM=$(uname)
LIB_PATH=$(find_lib_path)

echo "Building using ${LIB_PATH}"

gcc $INJECTOR_DIR/main.c "$LIB_PATH" -o $INJECTOR_DIR/main
