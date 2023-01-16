package main

import (
	"fmt"
	"io"
	"net/http"
	"os"
	"strconv"
	"time"
)

func main() {
	endpoint, ok := os.LookupEnv("ENDPOINT")
	if !ok {
		panic("Missing ENDPOINT environment variable.")
	}
	delayEnv, ok := os.LookupEnv("DELAY_MILLISECONDS")
	if !ok {
		panic("Missing DELAY_MILLISECONDS environment variable.")
	}
	delayMilliseconds, err := strconv.Atoi(delayEnv)
	if err != nil {
		panic(fmt.Sprintf("Unable to interpret DELAY_MILLISECONDS=%v as an integer: %v", delayEnv, err))
	}
	delay := time.Millisecond * time.Duration(delayMilliseconds)

	for {
		before := time.Now()
		response, err := http.Get(endpoint)
		if err != nil {
			fmt.Fprintln(os.Stderr, err)
			continue
		}
		defer response.Body.Close()
		_, err = io.ReadAll(response.Body)
		if err != nil {
			fmt.Fprintln(os.Stderr, err)
			continue
		}
		after := time.Now()
		fmt.Println(after.Sub(before).Nanoseconds(), before.UnixNano(), after.UnixNano())
		time.Sleep(delay)
	}
}
