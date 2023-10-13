package com.example.tumblrapp

import android.app.Application
import com.example.tumblrapp.di.modules.dataModule
import com.example.tumblrapp.di.modules.viewModelModule
import com.example.tumblrapp.di.modules.workerModule
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class TumblrApp : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TumblrApp)
            workManagerFactory()

            modules(
                viewModelModule,
                dataModule,
                workerModule
            )
        }
    }
}
