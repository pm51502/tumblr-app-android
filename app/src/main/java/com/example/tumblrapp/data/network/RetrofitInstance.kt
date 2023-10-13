package com.example.tumblrapp.data.network

import com.example.tumblrapp.BuildConfig
import com.example.tumblrapp.data.network.requests.BlogpostApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val blogpostApi: BlogpostApi by lazy {
    Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BlogpostApi::class.java)
}

