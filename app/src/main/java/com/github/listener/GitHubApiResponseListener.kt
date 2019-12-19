package com.github.listener

import com.github.models.GitHubModel

interface GitHubApiResponseListener {
    fun onApiSuccess(list: List<GitHubModel>?)
    fun OnApiError()
}