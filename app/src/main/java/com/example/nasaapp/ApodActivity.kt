package com.example.nasaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.nasaapp.databinding.ActivityApodBinding
import com.example.nasaapp.viewmodel.ApodViewModel

class ApodActivity : AppCompatActivity() {
    private lateinit var binding: ActivityApodBinding
    private lateinit var apodViewModel: ApodViewModel
    lateinit var title: String
    lateinit var explanation: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apod)
        apodViewModel = ViewModelProvider(this).get(ApodViewModel::class.java)

        binding = ActivityApodBinding.inflate(layoutInflater)
        this.supportActionBar?.hide()

        intent.let {
            title = it.getStringExtra("title").toString()
            explanation = it.getStringExtra("explanation").toString()
            findViewById<TextView>(R.id.text_title).text = title
            findViewById<TextView>(R.id.text_explanation).text = explanation
        }

    }


}