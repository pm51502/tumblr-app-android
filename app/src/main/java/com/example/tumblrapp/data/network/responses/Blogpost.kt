package com.example.tumblrapp.data.network.responses

import com.google.gson.annotations.SerializedName

data class Blogpost(
    val id: Long,
    @SerializedName("blog_name")
    val blogName: String,
    @SerializedName("post_url")
    val postUrl: String,
    val timestamp: Long,
    val tags: List<String>,
    val caption: String,
    val photos: List<Photo>,
    @SerializedName("note_count")
    val noteCount: Int
)
