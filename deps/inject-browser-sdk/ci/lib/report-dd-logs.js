const { getOrg2ApiKey } = require('./secrets')

const LOG_INTAKE_URL = 'https://http-intake.logs.datadoghq.com/api/v2/logs'
const LOG_INTAKE_REQUEST_HEADERS = {
  'DD-API-KEY': getOrg2ApiKey(),
  'Content-Type': 'application/json',
}

const sendLogToOrg2 = async (bundleData = {}) => {
  await fetch(LOG_INTAKE_URL, {
    method: 'POST',
    headers: LOG_INTAKE_REQUEST_HEADERS,
    body: JSON.stringify(bundleData),
  })
}

module.exports = { sendLogToOrg2 }
