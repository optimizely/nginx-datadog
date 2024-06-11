const { command } = require('./execution-utils')

const getGithubAccessToken = () => getSecretKey('ci.browser-sdk.github_access_token')

const getOrg2ApiKey = () => getSecretKey('ci.browser-sdk.datadog_ci_api_key')

const getOrg2AppKey = () => getSecretKey('ci.browser-sdk.datadog_ci_application_key')

const getSecretKey = (name) =>
  command`
    aws ssm get-parameter --region=us-east-1 --with-decryption --query=Parameter.Value --out=text --name=${name}
  `
    .run()
    .trim()

module.exports = {
  getGithubAccessToken,
  getOrg2ApiKey,
  getOrg2AppKey,
}
