package com.example.nasaapp.service.model

import com.google.gson.annotations.SerializedName

class HeaderModel {

    @SerializedName("copyright")
    lateinit var copyright: String

    @SerializedName("date")
    lateinit var date: String

    @SerializedName("explanation")
    lateinit var explanation: String

    @SerializedName("hdurl")
    lateinit var hdurl: String

    @SerializedName("media_type")
    lateinit var media_type: String

    @SerializedName("service_version")
    lateinit var service_version: String

    @SerializedName("title")
    lateinit var title: String

    @SerializedName("url")
    lateinit var url: String

}