package com.example.tumblrapp.ui.navigation

import com.example.tumblrapp.domain.models.Blogpost
import com.google.gson.Gson

class BlogpostArgType : JsonNavType<Blogpost>() {
    override fun fromJsonParse(value: String): Blogpost =
        Gson().fromJson(value, Blogpost::class.java)

    override fun Blogpost.getJsonParse(): String = Gson().toJson(this)
}
