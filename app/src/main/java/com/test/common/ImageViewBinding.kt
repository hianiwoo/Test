package com.test.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.test.test.R

@BindingAdapter("loadImage")
fun ImageView.loadImage(url: String?) {
        Glide.with(context)
            .load(url)
            .apply(
                RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .skipMemoryCache(true)
            )
            .into(this)
}