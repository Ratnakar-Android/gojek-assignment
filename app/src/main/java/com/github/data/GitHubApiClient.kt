package com.github.data

import com.github.listener.GitHubApiContract
import com.github.listener.GitHubApiResponseListener
import android.content.Context
import com.github.GitHubApplication
import com.github.models.GitHubModel
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class GitHubApiClient(var mContext: Context?) : GitHubApiContract {
    companion object {
        @JvmStatic
        @Volatile
        private var INSTANCE: GitHubApiClient? = null

        @JvmStatic
        fun getInstance(context: Context?): GitHubApiClient {
            return INSTANCE ?: synchronized(this) {
                GitHubApiClient(context).also { INSTANCE = it }
            }
        }
    }
    override fun callGitHubApi(onApiSuccess: GitHubApiResponseListener, handleErrorCode: GitHubApiResponseListener) {
        var app = mContext!!.applicationContext as GitHubApplication

        val networkCall: Single<retrofit2.Response<List<GitHubModel>>> = app.gitHubApi!!.getTopGitHubItems();
        networkCall.subscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(object : SingleObserver<retrofit2.Response<List<GitHubModel>>> {

            override fun onSubscribe(d: Disposable) {
            }
            override fun onSuccess(response: retrofit2.Response<List<GitHubModel>>) {
                if (response != null) {
                    var gitHubModelList: List<GitHubModel>? = response.body()
                    onApiSuccess.onApiSuccess(gitHubModelList)
                }
            }
            override fun onError(e: Throwable) {
            }
        });
    }
}