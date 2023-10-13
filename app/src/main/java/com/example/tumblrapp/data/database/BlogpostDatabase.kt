package com.example.tumblrapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tumblrapp.data.database.converters.BlogpostTagsConverter
import com.example.tumblrapp.data.database.dao.BlogpostDao
import com.example.tumblrapp.data.database.entity.BlogpostEntity

@Database(entities = [BlogpostEntity::class], version = 1)
@TypeConverters(BlogpostTagsConverter::class)
abstract class BlogpostDatabase : RoomDatabase() {
    abstract fun blogpostDao(): BlogpostDao
}
