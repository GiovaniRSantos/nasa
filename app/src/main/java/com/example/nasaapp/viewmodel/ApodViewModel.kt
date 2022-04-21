package com.example.nasaapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nasaapp.service.listener.APIListener
import com.example.nasaapp.service.model.HeaderModel
import com.example.nasaapp.service.repository.remote.NasaRepository
import com.google.gson.Gson

class ApodViewModel(application: Application) : AndroidViewModel(application) {

    private val mNasaRepository = NasaRepository()

    private val mApod = MutableLiveData<Boolean>()

    var apod: LiveData<Boolean> = mApod

    fun getInfosAstronomyPicOfTheDay(date: String) {
        mNasaRepository.getAstronomyPicOfTheDay(date, object : APIListener {
            override fun onSuccess(model: HeaderModel) {
                mApod.value = true

                var json = Gson().toJson(model)
                var body = Gson().fromJson(json, HeaderModel::class.java)

                model.date = body.date
                model.copyright = body.copyright
                model.explanation = body.explanation
                model.hdurl = body.hdurl
                model.title = body.title
            }

            override fun onFailure(str: String) {
                mApod.value = false
            }

        })
    }
}