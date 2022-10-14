package com.example.weatherapc.feature.data.model

import com.google.gson.annotations.SerializedName

data class WeathersRemoteModel(
    @SerializedName("main")
    val main: WeatherRemoteModel
//    @SerializedName("wind")
//    val wind: WeatherRemoteModel
)
