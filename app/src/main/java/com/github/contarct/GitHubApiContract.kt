package com.github.contarct

import com.github.listener.ApiResponseListener

interface GitHubApiContract {
    fun callGitHubApi(onApiSuccess: ApiResponseListener, handleErrorCode: ApiResponseListener)
}