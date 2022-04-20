package com.example.nasaapp.service.repository.remote

import com.example.nasaapp.service.model.HeaderModel
import com.example.nasaapp.service.constants.NasaConstants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaService {

    @GET("planetary/apod")
    fun getAstronomyPicOfTheDay(
        @Query("api_key") api_key: String,
        @Query("date") date: String
    ): Call<HeaderModel>
}