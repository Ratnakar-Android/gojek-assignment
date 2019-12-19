package com.github.repository

import com.github.listener.GitHubApiContract
import com.github.listener.GitHubApiResponseListener

class GitHubRepository(val gitHubApiContract: GitHubApiContract) : GitHubApiContract {

    companion object {
        @JvmStatic
        @Volatile
        private var INSTANCE: GitHubRepository? = null

        @JvmStatic
        fun getInstance(gitHubApiContract: GitHubApiContract): GitHubRepository {
            return INSTANCE ?: synchronized(this) {
                GitHubRepository(gitHubApiContract).also { INSTANCE = it }
            }
        }
    }

    override fun callGitHubApi(onApiSuccess: GitHubApiResponseListener, handleErrorCode: GitHubApiResponseListener) {
        gitHubApiContract.callGitHubApi(onApiSuccess, handleErrorCode)
    }
}