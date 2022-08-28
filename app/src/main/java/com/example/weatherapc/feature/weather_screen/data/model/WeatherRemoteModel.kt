package com.example.weatherapc.feature.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class WeatherRemoteModel(
    @SerializedName("main")
    val main : WeatherRemoteMainModel
)
