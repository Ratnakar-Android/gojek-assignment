package com.github.component

import com.github.data.GitHubApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [GitHubRetrofitBuilderModule::class])
class GitHubApiModule {

    @Provides
    fun getGitHubApi(builder : Retrofit.Builder): GitHubApi {
        var sGitHubApi: GitHubApi =  builder.build().create(GitHubApi::class.java)
        return sGitHubApi
    }
}