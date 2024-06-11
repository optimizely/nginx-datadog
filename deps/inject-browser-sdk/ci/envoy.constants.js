const ARTIFACTS_DIR = process.env.ARTIFACTS_DIR ?? 'artifacts'
const CI_COMMIT_REF_NAME = process.env.CI_COMMIT_REF_NAME
const CI_COMMIT_SHORT_SHA = process.env.CI_COMMIT_SHORT_SHA
const CI_JOB_URL = process.env.CI_JOB_URL ?? '-inject-browser-sdk-authanywhere'
const MAIN_BRANCH = process.env.MAIN_BRANCH ?? 'main'
const METRICS_PREFIX = 'rum_envoy_lua'
const PR_COMMENT_HEADER = 'Lua Injector Benchmarks'
const ROCKSPEC_DIR = process.env.ROCKSPEC_DIR ?? 'envoy-lua-filter' // meant to be from the root of the repo
const SERVICE_NAME = 'rum-browser-sdk-inject-envoy-lua'

const BASE_SCENARIO = 'base'
const RUM_SCENARIO = 'rum'
const SCENARIOS = [BASE_SCENARIO, RUM_SCENARIO]

module.exports = {
  ARTIFACTS_DIR,
  BASE_SCENARIO,
  CI_COMMIT_REF_NAME,
  CI_COMMIT_SHORT_SHA,
  CI_JOB_URL,
  MAIN_BRANCH,
  METRICS_PREFIX,
  PR_COMMENT_HEADER,
  ROCKSPEC_DIR,
  RUM_SCENARIO,
  SCENARIOS,
  SERVICE_NAME,
}
