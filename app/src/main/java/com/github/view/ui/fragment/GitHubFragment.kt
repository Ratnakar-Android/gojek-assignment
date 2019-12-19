package com.github.ui.fraggment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.github.databinding.GithubFragmentBinding
import net.one97.paytm.hotel4.view.adapter.GitHubAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.R
import com.github.data.GitHubApiClient
import com.github.models.GitHubModel
import com.github.repository.GitHubRepository
import com.github.viewmodel.GitHubListItemViewModel
import com.travel.train.viewModel.ViewModelFactory


class GitHubFragment : Fragment() {

    lateinit var dataBinding:GithubFragmentBinding
    var adapter : GitHubAdapter? = GitHubAdapter()
    lateinit var recleyerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

            dataBinding = DataBindingUtil.inflate(inflater, R.layout.github_fragment, container, false)
            recleyerView = dataBinding.githubRecycler
            recleyerView.setAdapter(adapter)


        if (context != null) {
            val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            divider.setDrawable(resources.getDrawable(R.drawable.recycler_view_divider))
            recleyerView.addItemDecoration(divider)
        }

        val viewModelFactory = ViewModelFactory(GitHubRepository.getInstance(GitHubApiClient.getInstance(context)))
        var mViewModel = ViewModelProviders.of(this, viewModelFactory).get(GitHubListItemViewModel::class.java)
        dataBinding.shimmerViewContainer.startShimmerAnimation()

        mViewModel.fetchTopListedItems()

        mViewModel.getGitHubList().observe(this, object : Observer<List<GitHubModel>> {
            override fun onChanged(@Nullable gitHubItemList: List<GitHubModel>?) {
                if (gitHubItemList != null) {
                    dataBinding.shimmerViewContainer.stopShimmerAnimation()
                    dataBinding.shimmerViewContainer.visibility = View.GONE
                    adapter?.setData(gitHubItemList)
                }
            }
        })
        return dataBinding.root
    }





}



