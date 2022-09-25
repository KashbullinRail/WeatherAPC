package com.example.weatherapc.featureWind.weather_screen.data.model

import com.google.gson.annotations.SerializedName


data class WeatherRemoteModel(
    @SerializedName("wind")
    val wind : WeatherRemoteMainModel
)
