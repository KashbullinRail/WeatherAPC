package com.example.weatherapc.featureTemp.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class WeatherRemoteMainModel(
    @SerializedName("temp")
    val temperature :String
)
