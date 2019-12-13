package com.github.ui.fraggment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.databinding.GithubFragmentBinding
import net.one97.paytm.hotel4.view.adapter.GitHubAdapter
import net.one97.paytm.hotel4.viewmodel.GitHubListItemViewModel
import androidx.recyclerview.widget.RecyclerView
import com.github.R


class GitHubMainFragment : Fragment() {

    lateinit var dataBinding:GithubFragmentBinding
    lateinit var viewModel: GitHubListItemViewModel
    lateinit var adapter: GitHubAdapter
    lateinit var recleyerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

            dataBinding = DataBindingUtil.inflate(inflater, R.layout.github_fragment, container, false)

            recleyerView = dataBinding.github_recycler
            recleyerView.setAdapter(adapter)

        return dataBinding.root



    }



}