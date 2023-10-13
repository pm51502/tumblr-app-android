package com.example.tumblrapp.data.network.requests

import com.example.tumblrapp.BuildConfig
import com.example.tumblrapp.data.network.responses.Blog
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BlogpostApi {

    @GET("posts/photo")
    suspend fun getBlogposts(
        @Query(value = "api_key") api_key: String = BuildConfig.API_KEY,
        @Query(value = "filter") filter: String = "text"
    ): Response<Blog>
}
