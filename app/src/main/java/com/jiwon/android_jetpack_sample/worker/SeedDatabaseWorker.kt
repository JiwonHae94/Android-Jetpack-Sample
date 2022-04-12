package com.jiwon.android_jetpack_sample.worker

import android.content.Context
import com.google.gson.stream.JsonReader
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jiwon.android_jetpack_sample.dao.AppDatabase
import com.jiwon.android_jetpack_sample.data.SplashData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SeedDatabaseWorker(
    context : Context,
    workerParams : WorkerParameters
) : CoroutineWorker(context, workerParams){
    override suspend fun doWork() : Result = withContext(Dispatchers.IO){
        try{
            val fileName = inputData.getString(KEY_FILENAME)
            if(fileName != null){
                applicationContext.assets.open(fileName).use { inputStream ->
                    JsonReader(inputStream.reader()).use { jsonReader ->
                        val plantType = object : TypeToken<List<SplashData>>() {}.type
                        val plantList: List<SplashData> = Gson().fromJson(jsonReader, plantType)

                        val database = AppDatabase.getInstance(applicationContext)
                        database.splashDao().insertAll(plantList)

                        Result.success()
                    }
                }
            }else{
                Log.e(TAG, "Error seeding database - no valid filename")
                Result.failure()
            }
        }catch(e : Exception){
            Log.e(TAG, e.stackTraceToString())
            Result.failure()
        }

    }

    companion object{
        private val TAG = SeedDatabaseWorker::class.java.simpleName
        const val KEY_FILENAME = "SPLASH_DATA_FILENAME"
    }
}