package com.jiwon.android_jetpack_sample.dao

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import com.jiwon.android_jetpack_sample.data.SplashData

@Database(entities = [SplashData::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun splashDao() : UnsplashDAO

    companion object{
        private const val DATABASE_NAME = ""
        @Volatile private var instance : AppDatabase? = null

        fun getInstance(context : Context) : AppDatabase{
            return instance ?: synchronized(this){
                instance ?: buildDatabase(context).also{ instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        private fun buildDatabase(context : Context) : RoomDatabase.Builder<AppDatabase> {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(
                    object : RoomDatabase.Callback(){
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)

                            val request = OneTimeWorkRequestBuilder<>()
                        }
                    }
                )

        }
    }
}