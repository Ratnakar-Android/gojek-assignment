package net.one97.paytm.hotel4.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.R
import com.github.databinding.ListItemBinding
import com.github.models.GitHubModel

class GitHubAdapter: RecyclerView.Adapter<GitHubAdapter.GitHubViewHolder>() {

    var gitHubItemList: List<GitHubModel>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubViewHolder {
         var layoutInflater : LayoutInflater = LayoutInflater.from(parent.getContext());
         var binding : ListItemBinding =  DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return GitHubViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (gitHubItemList == null) 0 else gitHubItemList !!.size
    }

    override fun onBindViewHolder(gitHubViewHolder: GitHubViewHolder, position: Int) {
        gitHubViewHolder.binding.github = gitHubItemList?.get(position)
        gitHubViewHolder.binding.executePendingBindings()
    }


    fun setData(gitHubItemList: List<GitHubModel>) {
        this.gitHubItemList = gitHubItemList
        notifyDataSetChanged()
    }

     class GitHubViewHolder(var binding: ListItemBinding) : RecyclerView.ViewHolder(binding.getRoot()), View.OnClickListener {
        init {
            this.binding = binding
        }

        override fun onClick(v: View) {
           // val index = this.adapterPosition
            //listener.onNewsItemClicked(articles.get(index))
        }
    }
}








