const { SCENARIOS } = require('../envoy.constants')

const reduceFailures = (summary) => {
  let errorCount = 0
  const errors = {}
  for (const [scenario, result] of Object.entries(summary)) {
    for (const [metric, value] of Object.entries(result.failure)) {
      const metricName = metric.replaceAll('.', '_')
      errors[metricName] = errors[metricName] || {}
      if (value > 0) {
        errors[metricName][scenario] = value
        errorCount += Number(value)
      }
    }
  }
  return { errorCount, errors }
}

const formatFailures = (reduction) => {
  const failures = ['### Failures', '| ❌ | envoy | +RUM |', '| --- | --- | --- |']
  for (const [metric, value] of Object.entries(reduction.errors)) {
    let result = `| *${metric}* `
    for (const knownScenario of SCENARIOS) {
      result += `| ${value[knownScenario] || ''} `
    }
    failures.push(`${result}|`)
  }

  if (reduction.errorCount > 0) {
    return failures.join('\n')
  }
  return ''
}

module.exports = { reduceFailures, formatFailures }
