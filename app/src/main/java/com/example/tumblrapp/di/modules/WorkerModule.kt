package com.example.tumblrapp.di.modules

import com.example.tumblrapp.workmanager.workers.FetchWorker
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.dsl.worker
import org.koin.dsl.module

val workerModule = module {
    worker {
        FetchWorker(
            appContext = androidContext(),
            workerParams = get(),
            blogpostRepository = get()
        )
    }
}
