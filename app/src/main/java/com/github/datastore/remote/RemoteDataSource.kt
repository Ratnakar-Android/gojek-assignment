package com.github.datastore.remote

import com.github.contarct.GitHubApiContract
import com.github.listener.ApiResponseListener
import android.content.Context
class RemoteDataSource (var mContext: Context): GitHubApiContract{


    companion object {
        @JvmStatic
        @Volatile
        private var INSTANCE: RemoteDataSource? = null

        @JvmStatic
        fun getInstance(context: Context): RemoteDataSource {
            return INSTANCE ?: synchronized(this) {
                RemoteDataSource(context).also { INSTANCE = it }
            }
        }
    }

    override fun callGitHubApi(onApiSuccess: ApiResponseListener, handleErrorCode: ApiResponseListener) {



    }


}