const path = require('path')
const fs = require('fs')
const {
  ARTIFACTS_DIR,
  CI_COMMIT_REF_NAME,
  CI_COMMIT_SHORT_SHA,
  PR_COMMENT_HEADER,
  ROCKSPEC_DIR,
  SERVICE_NAME,
} = require('./envoy.constants')
const { printError, printLog, runMain } = require('./lib/execution-utils')
const { reduceFailures, formatFailures } = require('./lib/envoy-failures')
const { reduceSuccesses, formatSuccesses } = require('./lib/envoy-successes')
const { compareToBaselineMetrics } = require('./lib/retrieve-baseline-metrics')
const { reportPrComment } = require('./lib/report-pr-comment')
const { sendLogToOrg2 } = require('./lib/report-dd-logs')

const LUA_ROCKSPEC_DIR = path.join(process.cwd(), ROCKSPEC_DIR) // meant to run from the root of the repo

runMain(async () => {
  const summary = JSON.parse(fs.readFileSync(path.resolve(process.cwd(), `${ARTIFACTS_DIR}/summary.json`), 'utf8'))

  const successes = reduceSuccesses(summary)
  const failures = reduceFailures(summary)

  const comparison = await compareToBaselineMetrics(successes)

  const formatted = {
    successes: formatSuccesses(successes, comparison),
    failures: formatFailures(failures),
  }

  await reportBenchmarksToDatadog({ successes, failures })
  await reportPrComment(
    PR_COMMENT_HEADER,
    `${formatted.successes}${failures.errorCount ? `\n\n${formatted.failures}` : ''}`
  )

  if (formatted.successes) {
    printLog(formatted.successes)
  }

  if (formatted.failures) {
    printError(formatted.failures)
    process.exit(1)
  }
})

const reportBenchmarksToDatadog = async (benchmarks) => {
  const luaScriptVersion = fs
    .readFileSync(findRockSpec(), 'utf8')
    .toString()
    .match(/version\s*=\s*"([^"]*)"/)[1]
  const logData = createLogData(benchmarks, luaScriptVersion)
  await sendLogToOrg2(logData)
}

const findRockSpec = () => {
  const pattern = /\.rockspec$/
  const files = fs.readdirSync(LUA_ROCKSPEC_DIR)
  const matchingFiles = files.filter((file) => {
    const filePath = path.join(LUA_ROCKSPEC_DIR, file)
    const stats = fs.statSync(filePath)
    return stats.isFile() && pattern.test(file)
  })
  return `${LUA_ROCKSPEC_DIR}/${matchingFiles.shift()}`
}

const createLogData = (benchmarks, luaScriptVersion) => [
  {
    message: 'RUM Browser Lua Injector Benchmarks',
    service: SERVICE_NAME,
    ddsource: 'browser-sdk',
    env: 'ci',
    benchmarks,
    version: luaScriptVersion,
    commit: CI_COMMIT_SHORT_SHA,
    branch: CI_COMMIT_REF_NAME,
  },
]
