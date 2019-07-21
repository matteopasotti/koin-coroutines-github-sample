package com.matteopasotti.github_app_koin.view.viewholder

import android.view.View
import androidx.databinding.DataBindingUtil
import com.matteopasotti.github_app_koin.model.GithubUser

class GithubUserViewHolder( view : View) : BaseViewHolder(view) {

    private lateinit var user : GithubUser

    private val binding by lazy { DataBindingUtil.bind<com.matteopasotti.github_app_koin.databinding.ItemGithubUserBinding>(view) }


    override fun bindData(data: Any?) {
        if( data is GithubUser) {
            user = data
            drawUI()
        }
    }

    override fun onClick(v: View?) {
    }

    private fun drawUI() {
        binding.apply {
            binding?.user = user
            binding?.executePendingBindings()
        }
    }
}