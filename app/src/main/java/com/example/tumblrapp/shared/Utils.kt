package com.example.tumblrapp.shared

import com.example.tumblrapp.data.database.entity.BlogpostEntity
import com.example.tumblrapp.data.network.responses.Blog
import com.example.tumblrapp.domain.models.Blogpost
import com.example.tumblrapp.domain.models.Tag
import java.text.SimpleDateFormat

fun Blog.toBlogpostList(): List<Blogpost> =
    this.response.posts.map {
        Blogpost(
            id = it.id,
            blogName = it.blogName,
            postUrl = it.postUrl,
            timestamp = it.timestamp,
            tags = it.tags.map { t ->
                Tag(name = t)
            },
            caption = it.caption,
            imageUrl = it.photos.first().originalSize.url,
            noteCount = it.noteCount
        )
    }

fun Long.toDate(): String {
    val sdf = SimpleDateFormat("dd.MM.yyyy")
    return sdf.format(this * 1000)
}

fun Blogpost.toEntity(): BlogpostEntity =
    BlogpostEntity(
        id = id,
        blogName = blogName,
        postUrl = postUrl,
        timestamp = timestamp,
        tags = tags.toMutableList(),
        caption = caption,
        imageUrl = imageUrl,
        noteCount = noteCount
    )

fun BlogpostEntity.toModel(): Blogpost =
    Blogpost(
        id = id,
        blogName = blogName,
        postUrl = postUrl,
        timestamp = timestamp,
        tags = tags.toList(),
        caption = caption,
        imageUrl = imageUrl,
        noteCount = noteCount
    )
