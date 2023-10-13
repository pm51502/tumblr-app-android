package com.example.tumblrapp.data.database.converters

import androidx.room.TypeConverter
import com.example.tumblrapp.domain.models.Tag

class BlogpostTagsConverter {
    @TypeConverter
    fun toString(tagList: MutableList<Tag>?): String? =
        tagList?.joinToString { it.name }

    @TypeConverter
    fun toTagList(tags: String?): MutableList<Tag>? =
        tags?.split(",")?.map { Tag(name = it) }?.toMutableList()
}
