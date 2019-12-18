package com.github.viewmodel

import android.R
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

 class PicassoViewModel {
    companion object {
        @JvmStatic
        @BindingAdapter("bind:imageUrl")
        fun loadImage(view: ImageView, imageUrl: String) {
            Picasso.with(view.getContext())
                    .load(imageUrl)
                    .into(view)
        }
    }
}

