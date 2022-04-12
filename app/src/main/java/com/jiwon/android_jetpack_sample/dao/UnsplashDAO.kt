package com.jiwon.android_jetpack_sample.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jiwon.android_jetpack_sample.data.SplashData

@Dao
interface UnsplashDAO {
    @Query("SELECT * FROM :db")
    fun getSplashes(db : String) : Float<List<SplashData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(splashes : List<SplashData>)
}