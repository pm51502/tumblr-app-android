package com.example.tumblrapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.WorkManager
import com.example.tumblrapp.ui.screens.MainScreen
import com.example.tumblrapp.ui.theme.TumblrAppTheme
import com.example.tumblrapp.workmanager.requests.PERIODIC_WORK_TAG
import com.example.tumblrapp.workmanager.requests.periodicFetchRequest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WorkManager
            .getInstance(applicationContext)
            .enqueueUniquePeriodicWork(
                PERIODIC_WORK_TAG,
                ExistingPeriodicWorkPolicy.REPLACE,
                periodicFetchRequest
            )

        setContent {
            TumblrAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}
