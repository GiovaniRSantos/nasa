package com.example.nasaapp.service.repository.remote

import com.example.nasaapp.service.constants.NasaConstants
import com.example.nasaapp.service.listener.APIListener
import com.example.nasaapp.service.model.HeaderModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NasaRepository {
    private val apiKey = NasaConstants.VALUES.APIKEY
    private val mRemote = RetrofitClient.createService(NasaService::class.java)


    fun getAstronomyPicOfTheDay(date: String, listener: APIListener) {
        val call: Call<HeaderModel> = mRemote.getAstronomyPicOfTheDay(apiKey, date)
        call.enqueue(object : Callback<HeaderModel> {
            override fun onResponse(call: Call<HeaderModel>, response: Response<HeaderModel>) {
                response.body()?.let { listener.onSuccess(it) }
            }

            override fun onFailure(call: Call<HeaderModel>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

        })
    }


}