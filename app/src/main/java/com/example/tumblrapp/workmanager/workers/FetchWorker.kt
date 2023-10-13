package com.example.tumblrapp.workmanager.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.tumblrapp.repository.BlogpostRepository
import com.example.tumblrapp.shared.toBlogpostList
import org.koin.core.component.KoinComponent

class FetchWorker(
    private val blogpostRepository: BlogpostRepository,
    appContext: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(appContext, workerParams), KoinComponent {

    companion object {
        private const val TAG = "FetchWorker"
    }

    override suspend fun doWork(): Result {
        val response = try {
            blogpostRepository.fetchBlogposts()
        } catch (e: Exception) {
            Log.e(TAG, "fetch failed ", e)
            return Result.failure()
        }

        return if (response.isSuccessful && response.body() != null) {
            response.body()?.also {
                blogpostRepository.insertBlogposts(blogpostList = it.toBlogpostList())
            }
            Log.i(TAG, "fetch successful")
            Result.success()
        } else {
            Log.e(TAG, "unknown error occurred")
            Result.failure()
        }
    }
}
