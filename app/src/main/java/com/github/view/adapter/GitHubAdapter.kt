package net.one97.paytm.hotel4.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import net.one97.paytm.hotel4.viewmodel.GitHubListItemViewModel

class GitHubAdapter(val viewmodel: GitHubListItemViewModel) :


//    DataBoundListAdapter<SortKeysItem>(
//        diffCallback = object : DiffUtil.ItemCallback<SortKeysItem>() {
//            override fun areItemsTheSame(
//                oldItemSRP: SortKeysItem?,
//                newItemSRP: SortKeysItem?
//            ): Boolean {
//                return oldItemSRP == newItemSRP
//            }
//
//            override fun areContentsTheSame(
//                oldItemSRP: SortKeysItem?,
//                newItemSRP: SortKeysItem?
//            ): Boolean {
//                return oldItemSRP == newItemSRP
//            }
//        }
//
//
//    ) {



    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.h4_sort_view_list_item,
            parent,
            false
        )
    }

    override fun bind(binding: ViewDataBinding, item: SortKeysItem) {

        when (binding) {
            is H4SortViewListItemBinding -> {

                binding.viewModel = viewmodel

                binding.viewModel?.setData(item)

                /*binding.viewModel = itemViewMOdel
                binding.viewModel?.setData(item)
                val linearLayoutManager =
                    GridLayoutManager(binding.root.context, 1, GridLayoutManager.HORIZONTAL, false)

                binding.recyclerHeaderImage.layoutManager = linearLayoutManager
                binding.recyclerHeaderImage.adapter =
                    SRPImageAdapter().also { it.submitList(item.paytmImages.full)*/
            }

        }
    }



/*
*
*

class SRPAdapter(private val viewModel: SRPViewModel, val itemViewMOdel: SRPListItemViewModel) :
DataBoundListAdapter<SRPDataItem>(
    diffCallback = object : DiffUtil.ItemCallback<SRPDataItem>() {
        override fun areItemsTheSame(oldItem: SRPDataItem, newItem: SRPDataItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: SRPDataItem, newItem: SRPDataItem): Boolean {
            return oldItem == newItem
        }
    }
) {
override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
    return DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.hotel4_srp_list_items,
        parent,
        false
    )
}

override fun bind(binding: ViewDataBinding, item: SRPDataItem) {
    when (binding) {
        is Hotel4SrpListItemsBinding -> {
            binding.viewModel = itemViewMOdel
            binding.viewModel?.setData(item)
            val linearLayoutManager =
                GridLayoutManager(binding.root.context, 1, GridLayoutManager.HORIZONTAL, false)

            binding.recyclerHeaderImage.layoutManager = linearLayoutManager
            binding.recyclerHeaderImage.adapter =
                SRPImageAdapter().also { it.submitList(item.paytmImages.full) }

        }
    }
}
}
* */