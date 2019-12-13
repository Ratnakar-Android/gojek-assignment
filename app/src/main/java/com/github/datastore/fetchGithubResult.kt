package com.github.datastore

import com.github.listener.ApiResponseListener

interface fetchGithubResult {
    fun callGitHubApi(onApiSuccess: ApiResponseListener, handleErrorCode: ApiResponseListener)
}