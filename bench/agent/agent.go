package main

import (
	"net/http"
)

func handle(w http.ResponseWriter, _ *http.Request) {
	w.Header().Add("Content-Type", "application/json")
	w.Write([]byte("{}"))
}

func main() {
	http.HandleFunc("/", handle)
	http.ListenAndServe(":8126", nil)
}
