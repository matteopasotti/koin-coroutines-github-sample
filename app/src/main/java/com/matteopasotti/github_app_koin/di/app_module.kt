package com.matteopasotti.github_app_koin.di

import com.matteopasotti.github_app_koin.repository.GithubUserRepository
import com.matteopasotti.github_app_koin.view.ui.MainActivityViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

val mainModule = applicationContext {

    bean { GithubUserRepository(get()) }

    viewModel { MainActivityViewModel(get()) }
}