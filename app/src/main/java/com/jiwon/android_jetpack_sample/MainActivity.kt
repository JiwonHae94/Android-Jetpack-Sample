package com.jiwon.android_jetpack_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jiwon.android_jetpack_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}