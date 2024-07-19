
CMAKE_VERSION=3.26.1
ARCHITECTURE=$(uname -m)
CMAKE_INSTALLER=cmake-${CMAKE_VERSION}-linux-${ARCHITECTURE}.sh
URL=https://github.com/Kitware/CMake/releases/download/v${CMAKE_VERSION}/${CMAKE_INSTALLER}

cd /tmp
if ! wget "${URL}"; then
    >&2 echo "wget failed to download \"${URL}\"."
    exit 1
fi
chmod +x "${CMAKE_INSTALLER}"
./"${CMAKE_INSTALLER}" --skip-license --prefix=/usr/local --exclude-subdir
rm "${CMAKE_INSTALLER}"
