const { BASE_SCENARIO, RUM_SCENARIO, SCENARIOS } = require('../envoy.constants')

const reduceSuccesses = (summary) => {
  let runsCount = 0
  const metrics = {}
  for (const [scenario, result] of Object.entries(summary).sort(sortScenarios)) {
    for (const [metric, value] of Object.entries(result.success[0])) {
      switch (metric) {
        case 'count':
          runsCount = value
          break
        case 'min':
        case 'max':
        case 'mean':
          accumulateMetric(metrics, scenario, metric, secondsToNumber(value))
          break
        case 'percentiles':
          for (const { percentile, duration, count } of value) {
            const percentileName = `p${Math.ceil(Number(percentile * 100))}`
            switch (percentileName) {
              case 'p50':
              case 'p75':
              case 'p95':
              case 'p99':
                accumulateMetric(metrics, scenario, percentileName, secondsToNumber(duration), count)
                break
            }
          }
          processP99Median(metrics, scenario)
          break
      }
    }
  }
  return { runsCount, metrics }
}

const formatSuccesses = (reduction, baseline) => {
  const successes = [
    `### Latency on 2xx responses (\`${reduction.runsCount} runs\`)`,
    '| 📈 | no filter | RUM injected | 𝚫 avg `main` |',
    '| --- | --- | --- | --- |',
  ]
  let runsCount = reduction.runsCount
  for (const [metric, value] of Object.entries(reduction.metrics).sort(sortMetrics)) {
    let result = `| **${metric}** `
    for (const knownScenario of SCENARIOS) {
      result += `| \`${formatSeconds(value[knownScenario].duration)}\` `
      result += formatCount(runsCount, value[knownScenario].count)
    }
    result += `| ${formatDelta(metricDiff(baseline[metric].duration, value[RUM_SCENARIO].duration))} `
    successes.push(`${result}|`)
  }

  if (successes.length > 3) {
    return successes.join('\n')
  }
  return ''
}

const accumulation = (duration, count, delta) => ({ duration, count, delta })

const accumulateMetric = (accumulator, scenario, metric, value, count) => {
  accumulator[metric] = accumulator[metric] || {}
  let delta
  if (metric === 'p99') {
    accumulator[metric][scenario] = accumulator[metric][scenario] || []
    accumulator[metric][scenario].push(accumulation(value, count, delta))
  } else {
    if (scenario === RUM_SCENARIO) {
      delta = metricDiff(accumulator[metric][BASE_SCENARIO].duration, value)
    }
    accumulator[metric][scenario] = accumulation(value, count, delta)
  }
}

const processP99Median = (accumulator, scenario) => {
  const { duration, count } = percentileMedian(accumulator['p99'][scenario])
  let delta
  if (scenario === RUM_SCENARIO) {
    delta = metricDiff(accumulator['p99'][BASE_SCENARIO].duration, duration)
  }
  accumulator['p99'][scenario] = accumulation(duration, count, delta)
}

const sortScenarios = ([a, _a], [b, _b]) => SCENARIOS.indexOf(a) - SCENARIOS.indexOf(b)

const sortMetrics = ([a, _a], [b, _b]) => {
  const order = ['mean', 'min', 'max', 'p50', 'p75', 'p95', 'p99']
  return order.indexOf(a) - order.indexOf(b)
}

const secondsToNumber = (seconds) => (typeof seconds === 'string' ? Number(seconds.slice(0, -1)) : seconds)

const formatSeconds = (seconds) =>
  [
    ['s', 1, 1],
    ['ms', 1e3, 3],
    ['ns', 1e6, 3],
  ]
    .map(([symbol, factor, padLeft]) => {
      const value = String(Math.trunc(secondsToNumber(seconds) * factor))
        .slice(-3)
        .padStart(padLeft, 0)
      return `${value}${symbol} `
    })
    .join('')
    .slice(0, -1)

const formatDelta = (delta) => (delta < 0 ? `🚀 \`${delta}%\`` : `😵 \`+${delta}%\``)

const formatCount = (total, count) => (typeof count !== 'undefined' ? `(${total - count}) ` : '')

const percentileMedian = (values) => {
  const sorted = Array.from(values).sort((a, b) => a.duration - b.duration)
  const middle = Math.floor(sorted.length / 2)

  if (sorted.length % 2 === 0) {
    return accumulation(
      (sorted[middle - 1].duration + sorted[middle].duration) / 2,
      (sorted[middle - 1].count + sorted[middle].count) / 2
    )
  }

  return sorted[middle]
}

const metricDiff = (baseline, rum) => {
  const baseSecs = secondsToNumber(baseline)
  return (((secondsToNumber(rum) - baseSecs) / baseSecs) * 100).toFixed(2)
}

module.exports = { reduceSuccesses, formatSuccesses }
