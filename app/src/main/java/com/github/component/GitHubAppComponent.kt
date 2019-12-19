package com.github.component

import com.github.data.GitHubApi
import dagger.Component

@Component(modules = [GitHubApiModule::class])
interface GitHubAppComponent {
    fun getGitHubApi(): GitHubApi
}