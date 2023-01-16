from golang:1.20rc1-alpine3.17 as build

workdir /usr/local/src/hurl
copy hurl.go /usr/local/src/hurl/main.go
run go mod init hurl && go get && go build -o /usr/local/bin/hurl

from alpine:3.17
copy --from=build /usr/local/bin/hurl /usr/local/bin/hurl

copy ./init /usr/local/bin/init
entrypoint ["/usr/local/bin/init"]
