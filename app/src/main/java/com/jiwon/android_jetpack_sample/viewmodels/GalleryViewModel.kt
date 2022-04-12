package com.jiwon.android_jetpack_sample.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel(
    val repository
) : ViewModel(){
    val text = MutableLiveData("")
}