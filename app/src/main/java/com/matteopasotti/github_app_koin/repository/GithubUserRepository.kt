package com.matteopasotti.github_app_koin.repository

import com.matteopasotti.github_app_koin.api.GithubService
import com.matteopasotti.github_app_koin.model.GithubUser

class GithubUserRepository (val githubApi: GithubService) : BaseRepository() {


    suspend fun getAllUsers() : MutableList<GithubUser>? {

        val usersResponse = safeApiCall(
            call = {githubApi.getAllUsers().await()},
            errorMessage = "Error fetching Users"
        )

        return usersResponse?.toMutableList()
    }
}