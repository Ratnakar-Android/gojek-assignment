package com.travel.train.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.repository.GitHubRepository
import com.github.viewmodel.GitHubListItemViewModel


class ViewModelFactory(private var repository: GitHubRepository): ViewModelProvider.Factory{

    companion object {
        @JvmStatic
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(repository: GitHubRepository): ViewModelFactory {
            return INSTANCE ?: synchronized(this) {
                ViewModelFactory(repository).also { INSTANCE = it }
            }
        }
    }
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return repository?.let { GitHubListItemViewModel(it) } as T
    }

}