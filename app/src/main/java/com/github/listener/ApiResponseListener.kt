package com.github.listener

import com.github.models.GitHubModel

interface ApiResponseListener {
    fun onApiSuccess(list: List<GitHubModel>?)
    fun OnApiError()
}