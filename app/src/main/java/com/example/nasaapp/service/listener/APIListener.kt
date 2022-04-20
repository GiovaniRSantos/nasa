package com.example.nasaapp.service.listener

import com.example.nasaapp.service.model.HeaderModel

interface APIListener {

    fun onSuccess(model: HeaderModel)

    fun onFailure(str: String)
}