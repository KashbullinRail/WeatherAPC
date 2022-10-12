package com.example.weatherapc.feature.data.model

import com.google.gson.annotations.SerializedName

data class WeatherRemoteModel(
    @SerializedName("main")
    val main : WeatherRemoteMainModel
)
