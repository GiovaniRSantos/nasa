package com.example.nasaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.nasaapp.databinding.ActivityApodBinding
import com.example.nasaapp.viewmodel.ApodViewModel

class ApodActivity : AppCompatActivity() {
    private lateinit var binding: ActivityApodBinding
    private lateinit var apodViewModel: ApodViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apod)
        apodViewModel = ViewModelProvider(this).get(ApodViewModel::class.java)

        binding = ActivityApodBinding.inflate(layoutInflater)

        binding.textTeste.text

    }
}