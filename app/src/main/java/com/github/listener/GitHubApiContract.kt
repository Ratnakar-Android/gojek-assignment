package com.github.listener

interface GitHubApiContract {
    fun callGitHubApi(onApiSuccess: GitHubApiResponseListener, handleErrorCode: GitHubApiResponseListener)
}