const { command } = require('./execution-utils')
const { getOrg2ApiKey, getOrg2AppKey } = require('./secrets')
const { MAIN_BRANCH, METRICS_PREFIX, RUM_SCENARIO } = require('../envoy.constants')

const BASE_BRANCH = MAIN_BRANCH
const ONE_DAY_IN_SECONDS = 24 * 60 * 60

const compareToBaselineMetrics = async ({ metrics }) => {
  const baselineMetrics = await retrieveBaselineMetrics(Object.keys(metrics))
  return Object.fromEntries(
    Object.entries(metrics).flatMap(([metricName, scenarios]) => {
      const value = scenarios[RUM_SCENARIO].duration
      const baseline = baselineMetrics.find((baselineMetric) => baselineMetric.name === metricName)
      if (baseline) {
        return [[metricName, { duration: baseline.size, delta: value - baseline.size }]]
      }
      return []
    })
  )
}

const retrieveBaselineMetrics = (metricNames) => {
  const lastCommonCommit = getLastCommonCommit(BASE_BRANCH)
  return fetchAllBaselineMetrics(metricNames, lastCommonCommit)
}

const getLastCommonCommit = (baseBranch) => {
  try {
    // command`git fetch origin`.run()
    const commandOutput = command`git merge-base origin/${baseBranch} HEAD`.run()
    // SHA commit is truncated to 8 caracters as bundle sizes commit are exported in short format to logs for convenience and readability.
    return commandOutput.trim().substring(0, 8)
  } catch (error) {
    throw new Error('Failed to get last common commit', { cause: error })
  }
}

function fetchAllBaselineMetrics(metricNames, commitSha) {
  return Promise.all(metricNames.map((metricName) => fetchBaselineMetrics(metricName, commitSha)))
}

const fetchBaselineMetrics = async (metricName, commitSha) => {
  const now = Math.floor(Date.now() / 1000)
  const date = now - 30 * ONE_DAY_IN_SECONDS
  const query = `avg:${METRICS_PREFIX}.${metricName}{commit:${commitSha}}&from=${date}&to=${now}`

  const response = await fetch(`https://api.datadoghq.com/api/v1/query?query=${query}`, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
      'DD-API-KEY': getOrg2ApiKey(),
      'DD-APPLICATION-KEY': getOrg2AppKey(),
    },
  })
  if (!response.ok) {
    throw new Error(`HTTP Error Response: ${response.status} ${response.statusText}`)
  }
  const data = await response.json()
  if (data.series && data.series.length > 0 && data.series[0].pointlist && data.series[0].pointlist.length > 0) {
    return {
      name: metricName,
      size: data.series[0].pointlist[0][1],
    }
  }
  return {
    name: metricName,
    size: null,
  }
}

module.exports = { compareToBaselineMetrics }
