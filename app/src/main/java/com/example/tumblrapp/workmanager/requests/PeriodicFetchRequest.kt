package com.example.tumblrapp.workmanager.requests

import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import com.example.tumblrapp.workmanager.workers.FetchWorker
import java.time.Duration

const val PERIODIC_WORK_TAG = "periodic_fetch_request"

val periodicFetchRequest =
    PeriodicWorkRequestBuilder<FetchWorker>(repeatInterval = Duration.ofHours(2))
        .setInitialDelay(Duration.ofSeconds(10))
        .setConstraints(
            Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build())
        .addTag(PERIODIC_WORK_TAG)
        .build()
