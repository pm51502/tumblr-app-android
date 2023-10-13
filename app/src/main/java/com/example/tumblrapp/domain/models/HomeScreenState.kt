package com.example.tumblrapp.domain.models

data class HomeScreenState(
    val isLoading: Boolean = false,
    val items: List<Blogpost> = emptyList(),
    val error: Throwable? = null,
)
