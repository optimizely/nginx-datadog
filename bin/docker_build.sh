#!/usr/bin/env sh
set -eu

usage() {
    cat <<'END_USAGE'
docker_build.sh - Create a build image in Docker

usage:

    docker_build.sh --platform <PLATFORM> [--yes] [--push] [--rm] [<BASE_IMAGE>]
        `docker build` an image suitable for building a Datadog nginx
        module compatible with the optionally specified BASE_IMAGE.
        If BASE_IMAGE is not specified, use the contents of the
        nginx-version-info file.

        Prompt the user for confirmation unless --yes is specified.

        --platform comma separated list of platform to build.
        Example: --platform linux/amd64,linux/arm64

        If --push is specified, push the resulting image to DockerHub
        with a suitable tag.

        If --rm is specified, then the image will be deleted locally after
        it's been build and/or pushed.

    docker_build.sh --help
    docker_build.sh -h
        Print this message.
END_USAGE
}

ask() {
    if [ "$yes" -eq 1 ]; then
        return
    fi

    while true; do
        printf '%s [Yn]: ' "$1"
        read -r response
        case "$response" in
            n|N|no|NO|No) return 1 ;;
            y|Y|yes|YES|Yes|'') return ;;
            *) >&2 printf "\nI don't understand.\n"
        esac
    done
}

repo=$(dirname "$0")/..
yes=0
push=0
# delete=0
platform=''
base_image=''

while [ $# -ne 0 ]; do
    case "$1" in
    -h|--help)
      usage
      exit
      ;;
    -y|--yes)
      yes=1
      ;;
    -p|--push)
      push=1
      ;;
    # -d|--rm)
    #   delete=1
    #   ;;
    --platform)
      platform="$2"
      shift
      ;;
    *)
        if [ -n "$base_image" ]; then
            >&2 printf 'base image was specified twice: first as %s and now as %s.' "$base_image" "$1"
            exit 1
        fi
        base_image="$1"
    esac
    shift
done

if [ -z "$base_image" ]; then
    # shellcheck disable=SC1091
    . "$repo/nginx-version-info"
    # shellcheck disable=SC2153
    base_image="$BASE_IMAGE"
fi

if [ -z "$platform" ]; then
  >&2 printf 'ERROR: missing platform.\n'
  usage
  exit
fi

base_image_without_colons=$(echo "$base_image" | tr ':' '_')
built_tag="nginx-datadog-build-$base_image_without_colons"

local_destination="$(pwd)/${built_tag}.tar"
remote_destination="datadog/docker-library:$built_tag"
buildx_output_args="--output=type=tar,dest=${local_destination}"

if ! ask "Build image compatible with ${base_image} for ${platform} and tag as ${built_tag}?"; then
    exit 1
fi

if [ "$push" -eq 0 ]; then
  if ask "Push built image to \"${remote_destination}\"?"; then
    buildx_output_args="--output=type=image,name=${remote_destination},push=true"
    push=1
    printf "Exporting to %s\n" "${remote_destination}"
  else
    printf "Exporting to %s\n" "${local_destination}"
  fi
fi

docker buildx build \
  --platform "${platform}" \
  --build-arg "BASE_IMAGE=${base_image}" \
  "${buildx_output_args}" \
  "${repo}"

# if [ "$delete" -eq 1 ] && [ "$push" -eq 0 ]; then
#     docker images --no-trunc | awk "{ if (\$2 == \"$built_tag\") { print \$3 } }" | xargs docker rmi --force
# fi
