package com.example.tumblrapp.domain.models

import android.net.Uri
import com.google.gson.Gson

data class Blogpost(
    val id: Long,
    val blogName: String,
    val postUrl: String,
    val timestamp: Long,
    val tags: List<Tag>,
    val caption: String,
    val imageUrl: String,
    val noteCount: Int
) {
    override fun toString(): String = Uri.encode(Gson().toJson(this))
}
