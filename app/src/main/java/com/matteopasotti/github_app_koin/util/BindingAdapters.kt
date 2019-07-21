package com.matteopasotti.github_app_koin.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {

    if (url != null) {
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }

}