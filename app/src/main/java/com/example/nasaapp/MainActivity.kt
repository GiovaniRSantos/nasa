package com.example.nasaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nasaapp.databinding.ActivityMainBinding
import com.example.nasaapp.viewmodel.ApodViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mViewModel: ApodViewModel
    private lateinit var binding: ActivityMainBinding
    lateinit var date: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewModel = ViewModelProvider(this).get(ApodViewModel::class.java)

        setListener()
        observe()
    }

    private fun setListener() {
        binding.buttonEnter.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_enter) {
            getBirthdayDate()
            mViewModel.getInfosAstronomyPicOfTheDay(date)
        } else {
            Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getBirthdayDate() {
        date = binding.editTextBirthdate.text.toString()
    }

    private fun observe() {
        mViewModel.apod.observe(this) {
            if (date != " ") {
                binding.editTextBirthdate.text.clear()
                startActivity(Intent(this, ApodActivity::class.java))
            } else {
                Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show()
            }
        }
    }

}