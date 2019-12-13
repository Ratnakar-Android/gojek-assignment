package com.github.listener

import com.github.models.GitHubItem

interface ApiResponseListener {
    fun onApiSuccess(itemList : GitHubItem)
    fun OnApiError()
}