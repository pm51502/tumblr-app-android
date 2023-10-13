package com.example.tumblrapp.data.network.responses

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("original_size")
    val originalSize: PhotoOriginalSize
)
