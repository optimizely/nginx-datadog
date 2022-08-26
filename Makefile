.DELETE_ON_ERROR:

# The nginx-tag file might end in "-alpine".  We're interested in the
# nginx source version only.
NGINX_VERSION = $(shell sed 's/-.*//' nginx-tag)
BUILD_DIR ?= .build
MAKE_JOB_COUNT ?= $(shell nproc)

.PHONY: build
build: build-deps nginx/objs/Makefile sources
	mkdir -p $(BUILD_DIR) && cd $(BUILD_DIR) && cmake -DBUILD_TESTING=OFF .. && make -j $(MAKE_JOB_COUNT) VERBOSE=1
	@echo 'build successful 👍'

.PHONY: sources
sources: dd-trace-cpp/.git nginx/

.PHONY: build-deps
build-deps: sources dd-trace-cpp-deps

dd-trace-cpp/.git:
	git submodule update --init --recursive

.PHONY: dd-trace-cpp-deps
dd-trace-cpp-deps: dd-trace-cpp/.git

nginx/objs/Makefile: nginx/ module/config
	cd nginx && ./configure --add-dynamic-module=../module/ --with-compat
	
nginx/: nginx-tag
	rm -rf nginx && \
	    curl -s -S -L -o nginx.tar.gz "$(shell bin/nginx_release_downloads.sh $(NGINX_VERSION))" && \
		mkdir nginx && \
		tar xzf nginx.tar.gz -C nginx --strip-components 1 && \
		rm nginx.tar.gz

# In the "build" target, we use ./nginx-tag just for the nginx version (to download the appropriate sources).
# In the "build-in-docker" target, we use ./nginx-tag to also identify the appropriate base image.
nginx-tag:
	$(error The file "nginx-tag" must be present and contain the tag name of the desired compatible nginx Docker image, e.g. "1.19.1" or "1.21.3-alpine")

dd-trace-cpp/.clang-format: dd-trace-cpp/.git
	
.clang-format: dd-trace-cpp/.clang-format
	cp $< $@

.PHONY: format
format: .clang-format
	find src/ -type f \( -name '*.h' -o -name '*.cpp' \) -not \( -name 'json.h' -o -name 'json.cpp' \) -print0 | xargs -0 clang-format-14 -i --style=file	
	find bin/ -type f -name '*.py' -print0 | xargs -0 yapf3 -i
	test/bin/format

.PHONY: clean
clean:
	rm -rf \
		.build \
		.docker-build
	
.PHONY: clobber
clobber: clean
	rm -rf \
	    nginx

.PHONY: build-in-docker
build-in-docker: sources
	bin/run_in_build_image.sh $(MAKE) BUILD_DIR=.docker-build build

.PHONY: test
test: build-in-docker
	cp .docker-build/libngx_http_datadog_module.so test/services/nginx/ngx_http_datadog_module.so
	test/bin/run $(TEST_ARGS)

.PHONY: test-parallel
test-parallel: build-in-docker
	cp .docker-build/libngx_http_datadog_module.so test/services/nginx/ngx_http_datadog_module.so
	test/bin/run_parallel $(TEST_ARGS)
