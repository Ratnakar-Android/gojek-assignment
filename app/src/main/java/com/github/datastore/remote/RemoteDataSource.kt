package com.github.datastore.remote

import com.github.contarct.GitHubApiContract
import com.github.listener.ApiResponseListener
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.github.models.GitHubItem
import com.github.models.GitHubModel
import com.github.utils.DateDeserializer
import com.google.gson.GsonBuilder
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.*
import okhttp3.Response
import okhttp3.Interceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit

class RemoteDataSource(var mContext: Context?): GitHubApiContract{


    private val NEWS_API_URL = "https://github-trending-api.now.sh"
    lateinit var sGitHubApi: GitHubApi



    companion object {
        @JvmStatic
        @Volatile
        private var INSTANCE: RemoteDataSource? = null

        @JvmStatic
        fun getInstance(context: Context?): RemoteDataSource {
            return INSTANCE ?: synchronized(this) {
                RemoteDataSource(context).also { INSTANCE = it }
            }
        }
    }

    override fun callGitHubApi(onApiSuccess: ApiResponseListener, handleErrorCode: ApiResponseListener) {

        // 5 MB of cache
        val cache = Cache(mContext!!.getApplicationContext().getCacheDir(), 5 * 1024 * 1024)

        // Used for cache connection
        val networkInterceptor = object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                // set max-age and max-stale properties for cache header
                val cacheControl = CacheControl.Builder()
                        .maxAge(1, TimeUnit.HOURS)
                        .maxStale(3, TimeUnit.DAYS)
                        .build()
                return chain.proceed(chain.request())
                        .newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", cacheControl.toString())
                        .build()
            }
        }

        // For logging
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


        // Building OkHttp client
        val client = OkHttpClient.Builder()
                .cache(cache)
                .addNetworkInterceptor(networkInterceptor)
                .addInterceptor(loggingInterceptor)
                .build()

        // Configure GSON
        val gson = GsonBuilder()
                .registerTypeAdapter(Date::class.java, DateDeserializer())
                .create()

        // Retrofit Builder
        val builder = Retrofit.Builder()
                .baseUrl(NEWS_API_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))


        sGitHubApi =  builder.build().create(GitHubApi::class.java)


        val networkArticleLiveData : MutableLiveData<List<GitHubItem>> = MutableLiveData()



       val networkCall : Single<retrofit2.Response<List<GitHubModel>>> = sGitHubApi.getTopGitHubItems();


        networkCall.subscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(object : SingleObserver<retrofit2.Response<List<GitHubModel>>> {

            override fun onSubscribe(d: Disposable) {

            }

            override fun onSuccess(response: retrofit2.Response<List<GitHubModel>> ) {

                    if (response != null){
                          var gitHubModelList : List<GitHubModel>? = response.body()
                          var gitHubModel : GitHubModel = gitHubModelList!!.get(0)
                          var gitHubItems :List<GitHubItem>  = gitHubModel.builtBy
                          networkArticleLiveData.postValue(gitHubItems)
                        onApiSuccess.onApiSuccess(gitHubModelList)
                    }
            }

            override fun onError(e: Throwable) {
            }
        });

    }


}