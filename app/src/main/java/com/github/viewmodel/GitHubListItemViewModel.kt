package net.one97.paytm.hotel4.viewmodel

import android.view.View
import androidx.annotation.Nullable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.listener.ApiResponseListener
import com.github.models.GitHubItem
import com.github.repository.GitHubRepository

class GitHubListItemViewModel(@Nullable private var mRepo: GitHubRepository) : ViewModel(), ApiResponseListener {


    private var gitHubList: MutableLiveData<GitHubItem>

   init {
       gitHubList = MutableLiveData()
   }

    // Call Api for fetching Git top listed items
    fun fetchTopListedItems(){

        mRepo.callGitHubApi(this, this)



    }

    fun getGitHubList() : LiveData<GitHubItem> = gitHubList


    override fun onApiSuccess(itemList: GitHubItem) {
        if (itemList != null){
            if (itemList is GitHubItem){
                gitHubList.postValue(itemList)
            }
        }
    }

    override fun OnApiError() {
    }


}