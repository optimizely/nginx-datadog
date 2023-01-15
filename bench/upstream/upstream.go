package main

import (
	"net/http"
)

func handle(_ http.ResponseWriter, _ *http.Request) {
}

func main() {
	http.HandleFunc("/", handle)
	http.ListenAndServe(":80", nil)
}
