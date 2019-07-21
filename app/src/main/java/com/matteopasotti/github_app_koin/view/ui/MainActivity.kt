package com.matteopasotti.github_app_koin.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.matteopasotti.github_app_koin.R
import com.matteopasotti.github_app_koin.databinding.ActivityMainBinding
import com.matteopasotti.github_app_koin.view.adapter.GithubUserAdapter
import org.koin.android.architecture.ext.viewModel

class MainActivity : AppCompatActivity() {

    val viewModel : MainActivityViewModel by viewModel()

    private val binding by lazy { DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val linearLayout = androidx.recyclerview.widget.LinearLayoutManager(this)
        binding.listUsers.layoutManager = linearLayout
        viewModel.adapter = GithubUserAdapter()
        binding.listUsers.adapter = viewModel.adapter


        viewModel.users.observe(this, Observer { response ->
            if (response != null) {
                viewModel.adapter.updateList(response)
            }
        })

        viewModel.getAllUsers()
    }
}