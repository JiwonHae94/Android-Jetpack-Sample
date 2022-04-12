package com.jiwon.android_jetpack_sample.repository

import com.jiwon.android_jetpack_sample.api.UnsplashService
import com.jiwon.android_jetpack_sample.dao.UnsplashDAO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GalleryRepository @Inject constructor(
    private val unsplashService : UnsplashService,
    private val unsplashDAO : UnsplashDAO
){
    suspend fun searchPhotos(){
        unsplashService.searchPhotos(//TODO
        )
    }
}