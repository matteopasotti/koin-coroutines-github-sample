package com.matteopasotti.github_app_koin.view.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matteopasotti.github_app_koin.model.GithubUser
import com.matteopasotti.github_app_koin.repository.GithubUserRepository
import com.matteopasotti.github_app_koin.view.adapter.GithubUserAdapter
import kotlinx.coroutines.launch

class MainActivityViewModel(private val githubUserRepository: GithubUserRepository) : ViewModel(){

    lateinit var adapter : GithubUserAdapter

    private val _users = MutableLiveData<List<GithubUser>>()
    val users: LiveData<List<GithubUser>> = _users

    fun getAllUsers() {
        viewModelScope.launch {
            _users.postValue(githubUserRepository.getAllUsers())
        }
    }

    // No need to override onCleared()
}