package com.example.nasaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.nasaapp.databinding.ActivityMainBinding
import com.example.nasaapp.viewmodel.ApodViewModel


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mViewModel: ApodViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var date: String
    private lateinit var dateFormated: String

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
            convertMaskDate(date)
            mViewModel.getInfosAstronomyPicOfTheDay(dateFormated)
        } else {
            Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getBirthdayDate() {
        date = binding.editTextBirthdate.text.toString()
    }

    private fun convertMaskDate(date: String) {
        if (date != "") {
            dateFormated =
                date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.subSequence(6, 8)
        } else {
            dateFormated = ""
        }
    }

    private fun observe() {
        mViewModel.apod.observe(this) {
            if (it != null) {
                binding.editTextBirthdate.text.clear()
                val intent = Intent(this, ApodActivity::class.java)
                intent.putExtra("title", it.title)
                intent.putExtra("explanation", it.explanation)
                intent.putExtra("url", it.url)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show()
            }
        }
    }

}