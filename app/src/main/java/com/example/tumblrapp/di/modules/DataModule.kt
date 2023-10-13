package com.example.tumblrapp.di.modules

import androidx.room.Room
import com.example.tumblrapp.data.database.BlogpostDatabase
import com.example.tumblrapp.data.network.blogpostApi
import com.example.tumblrapp.repository.BlogpostRepository
import com.example.tumblrapp.repository.BlogpostRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single {
        blogpostApi
    }
    single<BlogpostRepository> {
        BlogpostRepositoryImpl(
            blogpostApi = get(),
            blogpostDao = get()
        )
    }
    single {
        Room.databaseBuilder(
            androidContext(),
            BlogpostDatabase::class.java,
            "blogpost-db"
        ).build()
    }
    single {
        val database = get<BlogpostDatabase>()
        database.blogpostDao()
    }
}
