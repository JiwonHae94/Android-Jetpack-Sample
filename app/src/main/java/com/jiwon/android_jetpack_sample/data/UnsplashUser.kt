package com.jiwon.android_jetpack_sample.data

import com.google.gson.annotations.SerializedName

/**
 * represents user
 */
data class UnsplashUser(
    @SerializedName("name") val name : String,
    @SerializedName("username") val username : String
){
    val attributionURL : String
        get() {
            return "https://unsplash.com/$username?utm_source=sunflower&utm_medium=referral"
        }
}