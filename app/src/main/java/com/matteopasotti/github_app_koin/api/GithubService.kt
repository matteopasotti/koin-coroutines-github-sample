package com.matteopasotti.github_app_koin.api

import androidx.lifecycle.LiveData
import com.matteopasotti.github_app_koin.model.Follower
import com.matteopasotti.github_app_koin.model.FollowerResponse
import com.matteopasotti.github_app_koin.model.GithubUser
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {


    /**
     * https://api.github.com/users?since=135
     *
     * Lists all users, in the order that they signed up on GitHub.
     *
     * Pagination is powered exclusively by the since parameter
     */
    @GET("/users")
    fun getAllUsers() : Deferred<Response<List<GithubUser>>>



    /**
     * [Users](https://developer.github.com/v3/users/)
     *
     * Provides publicly available information about someone with a GitHub account.
     *
     * @param [user] the name of the user.
     *
     * @return [GithubUser] github user model.
     */
    @GET("/users/{user}")
    fun fetchGithubUser(@Path("user") user: String): LiveData<ApiResponse<GithubUser>>

    /**
     * [Followers](https://developer.github.com/v3/users/followers/#list-followers-of-a-user)
     *
     * List the authenticated user's followers.
     *
     * @param [user] the name of a user.
     * @param [page] the number of a page.
     * @param [per_page] the number of followers per page.
     *
     * @return [Follower] github user model.
     */
    @GET("/users/{user}/followers")
    fun fetchFollowers(@Path("user") user: String, @Query("page") page: Int, @Query("per_page") per_page: Int): Deferred<Response<FollowerResponse>>

    /**
     * [Followings](https://developer.github.com/v3/users/followers/#check-if-you-are-following-a-user)
     *
     * List who a user is following.
     *
     * @param [user] the name of the user.
     * @param [page] the number of a page.
     * @param [per_page] the number of followers per page
     *
     * @return [Follower] github follower model.
     */
    @GET("/users/{user}/following")
    fun fetchFollowings(@Path("user") user: String, @Query("page") page: Int, @Query("per_page") per_page: Int): LiveData<ApiResponse<List<Follower>>>
}