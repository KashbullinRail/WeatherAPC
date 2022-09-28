package com.example.weatherapc.featureWind.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class WeatherRemoteMainModelWind(
    @SerializedName("speed")
    val speed: String,
    @SerializedName("deg")
    val deg: String
)

