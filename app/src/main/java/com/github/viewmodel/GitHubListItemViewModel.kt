package com.github.viewmodel
import androidx.annotation.Nullable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.listener.GitHubApiResponseListener
import com.github.models.GitHubModel
import com.github.repository.GitHubRepository

 class GitHubListItemViewModel(@Nullable private var mRepo: GitHubRepository) : ViewModel(), GitHubApiResponseListener {


     var gitHubList: MutableLiveData<List<GitHubModel>>

   init {
       gitHubList = MutableLiveData()
   }

    // Call Api for fetching Git top listed items

    fun fetchTopListedItems(){
        mRepo.callGitHubApi(this, this)
    }

    fun getGitHubList() : LiveData <List<GitHubModel>> = gitHubList


    override fun onApiSuccess(itemList: List<GitHubModel>?) {

        if (itemList != null){
            gitHubList.postValue(itemList)
        }
    }

    override fun OnApiError() {
    }


}