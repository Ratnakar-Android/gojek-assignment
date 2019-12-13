package com.github.repository

import com.github.contarct.GitHubApiContract
import com.github.datastore.remote.RemoteDataSource
import com.github.listener.ApiResponseListener

class GitHubRepository (val gitHubApiContract: GitHubApiContract) : GitHubApiContract   {


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

    override fun callGitHubApi(onApiSuccess: ApiResponseListener, handleErrorCode: ApiResponseListener) {
        gitHubApiContract.callGitHubApi(onApiSuccess, handleErrorCode)
    }


}