#! /usr/bin/env sh

# Start server
taskset -c 2 nice -n 0 ${NIGHTHAWK_SRC}/bazel-bin/nighthawk_test_server --concurrency 1 --config-path /etc/envoy.yaml &

sleep 3

# Run benchmarks on base Envoy
taskset -c 3 nice -n 0 ${NIGHTHAWK_SRC}/bazel-bin/nighthawk_client --connections 4 --concurrency auto --prefetch-connections -v info --output-format json --rps 1000 --simple-warmup http://127.0.0.1:8081/ 1>${ARTIFACTS_DIR}/report-base.json
# Run benchmarks on Envoy + RUM injection
taskset -c 3 nice -n 0 ${NIGHTHAWK_SRC}/bazel-bin/nighthawk_client --connections 4 --concurrency auto --prefetch-connections -v info --output-format json --rps 1000 --simple-warmup http://127.0.0.1:8080/ 1>${ARTIFACTS_DIR}/report-rum.json

# Summarize
summary="{";
for result_file in base rum
do
  result=$(jq -M '{failure: .options.failure_predicates, success: [(.results[].statistics[] | select(.id | . and contains("benchmark_http_client.latency_2xx")))]}' ${ARTIFACTS_DIR}/report-$result_file.json)
  summary="$summary\"$result_file\":$result,"
done

echo "${summary%?}}" > ${ARTIFACTS_DIR}/summary.json;
