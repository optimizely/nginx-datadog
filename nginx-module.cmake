# This file is generated by bin/generate_cmakelists.py
cmake_minimum_required(VERSION 3.12)

project(nginx_module)

find_path(PCRE2_INCLUDE_DIR pcre2.h)

add_library(nginx_module OBJECT)

set_property(TARGET nginx_module PROPERTY POSITION_INDEPENDENT_CODE ON)

target_sources(nginx_module
  PRIVATE
    ${NGINX_DIR}/objs/ngx_http_datadog_module_modules.c
)

include_directories(
  PUBLIC
    ${PCRE2_INCLUDE_DIR}
    ${NGINX_DIR}/src/event
    ${NGINX_DIR}/src/http/modules
    ${NGINX_DIR}/src/http
    ${NGINX_DIR}/src/os/unix
    ${NGINX_DIR}/objs
    ${NGINX_DIR}/src/core
    ${NGINX_DIR}/src/event/modules
)

