package com.jiwon.android_jetpack_sample.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "splash")
data class SplashData(
    @PrimaryKey @ColumnInfo(name = "id") val uuid : UUID
)
