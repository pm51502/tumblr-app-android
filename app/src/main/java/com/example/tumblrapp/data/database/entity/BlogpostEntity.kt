package com.example.tumblrapp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tumblrapp.domain.models.Tag

@Entity(tableName = "blogpost")
data class BlogpostEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "blog_name")
    val blogName: String,
    @ColumnInfo(name = "post_url")
    val postUrl: String,
    val timestamp: Long,
    val tags: MutableList<Tag>,
    val caption: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String,
    @ColumnInfo(name = "note_count")
    val noteCount: Int
)
