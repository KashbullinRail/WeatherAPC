package com.example.weatherapc.featureWind.weather_screen.data.model

import com.google.gson.annotations.SerializedName


data class WeatherRemoteModelWind(
    @SerializedName("wind")
    val wind : WeatherRemoteMainModelWind
)
