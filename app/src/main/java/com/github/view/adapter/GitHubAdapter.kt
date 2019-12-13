package net.one97.paytm.hotel4.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.R
import com.github.databinding.ListItemBinding
import net.one97.paytm.hotel4.viewmodel.GitHubListItemViewModel

class GitHubAdapter(mContext: Context?,val viewmodel: GitHubListItemViewModel): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

      lateinit var layoutInflater:LayoutInflater
      lateinit var binding: ListItemBinding



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created funxctions use File | Settings | File Templates.
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
         binding =  DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }
}





}


