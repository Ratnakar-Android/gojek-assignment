package com.github

import android.app.Application
import com.github.component.GitHubContextModule
import com.github.component.DaggerGitHubAppComponent
import com.github.component.GitHubAppComponent
import com.github.data.GitHubApi

class GitHubApplication : Application() {

    var gitHubApi: GitHubApi? = null
    var appComponent: GitHubAppComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerGitHubAppComponent.builder().gitHubContextModule(GitHubContextModule(this.applicationContext)).build()
        gitHubApi = appComponent!!.getGitHubApi()

    }
}