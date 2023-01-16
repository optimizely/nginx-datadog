from golang:1.20rc1-alpine3.17 as build

workdir /usr/local/src/spam
copy spam.go /usr/local/src/spam/main.go
run go build -o /usr/local/bin/spam main.go

from alpine:3.17
copy --from=build /usr/local/bin/spam /usr/local/bin/spam

copy ./init /usr/local/bin/init
entrypoint ["/usr/local/bin/init"]
