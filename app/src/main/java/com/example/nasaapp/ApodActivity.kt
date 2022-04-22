package com.example.nasaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.nasaapp.databinding.ActivityApodBinding
import com.example.nasaapp.viewmodel.ApodViewModel
import com.squareup.picasso.Picasso
import java.net.URL

class ApodActivity : AppCompatActivity() {
    private lateinit var binding: ActivityApodBinding
    private lateinit var apodViewModel: ApodViewModel
    lateinit var title: String
    lateinit var explanation: String
    lateinit var url: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apod)
        apodViewModel = ViewModelProvider(this).get(ApodViewModel::class.java)

        binding = ActivityApodBinding.inflate(layoutInflater)
        this.supportActionBar?.hide()

        intent.let {
            title = it.getStringExtra("title").toString()
            explanation = it.getStringExtra("explanation").toString()
            url = it.getStringExtra("url").toString()
            findViewById<TextView>(R.id.text_title).text = title
            findViewById<TextView>(R.id.text_explanation).text = explanation
            getImage()
        }

    }

    private fun getImage() {
        var url = URL(url)
        val image = findViewById<ImageView>(R.id.image)
        Picasso.get().load(url.toString()).into(image)
    }


}