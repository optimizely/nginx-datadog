const { command, printError } = require('./execution-utils')
const { getGithubAccessToken } = require('./secrets')
const { CI_COMMIT_REF_NAME, CI_JOB_URL, PR_COMMENT_HEADER } = require('../envoy.constants')

const LOCAL_BRANCH = CI_COMMIT_REF_NAME
const PR_COMMENTER_AUTH_TOKEN = command`authanywhere`.run().split(' ')[2].trim()
const GITHUB_TOKEN = getGithubAccessToken()

const reportPrComment = async (header, message) => {
  const pr = await fetchPR(LOCAL_BRANCH)
  if (!pr) {
    printError('No pull requests found for the branch')
    return
  }
  const commentId = await retrieveExistingCommentId(pr.number, PR_COMMENT_HEADER)
  await updateOrAddComment(header, message, pr.number, commentId)
}

const fetchPR = async (localBranch) => {
  const response = await fetch(
    `https://api.github.com/repos/DataDog/inject-browser-sdk/pulls?head=DataDog:${localBranch}`,
    {
      method: 'GET',
      headers: {
        Authorization: `token ${GITHUB_TOKEN}`,
      },
    }
  )
  if (!response.ok) {
    throw new Error(`HTTP Error Response: ${response.status} ${response.statusText}`)
  }
  const pr = response.body ? await response.json() : null
  if (pr && pr.length > 1) {
    throw new Error('Multiple pull requests found for the branch')
  }
  return pr ? pr[0] : null
}

const retrieveExistingCommentId = async (prNumber, header) => {
  const response = await fetch(`https://api.github.com/repos/DataDog/inject-browser-sdk/issues/${prNumber}/comments`, {
    method: 'GET',
    headers: {
      Authorization: `token ${GITHUB_TOKEN}`,
    },
  })
  if (!response.ok) {
    throw new Error(`HTTP Error Response: ${response.status} ${response.statusText}`)
  }
  const comments = await response.json()
  const targetComment = comments.find((comment) => comment.body.startsWith(`## ${header}`))
  if (targetComment !== undefined) {
    return targetComment.id
  }
}

const updateOrAddComment = async (header, message, prNumber, commentId) => {
  const method = commentId ? 'PATCH' : 'POST'
  const payload = {
    pr_url: `https://github.com/DataDog/inject-browser-sdk/pull/${prNumber}`,
    message,
    header,
    org: 'DataDog',
    repo: 'inject-browser-sdk',
  }
  const response = await fetch('https://pr-commenter.us1.ddbuild.io/internal/cit/pr-comment', {
    method,
    headers: {
      Authorization: `Bearer ${PR_COMMENTER_AUTH_TOKEN}`,
      'X-DdOrigin': `${CI_JOB_URL}`,
    },
    body: JSON.stringify(payload),
  })
  if (!response.ok) {
    throw new Error(`HTTP Error Response: ${response.status} ${response.statusText}`)
  }
}

module.exports = {
  reportPrComment,
}
