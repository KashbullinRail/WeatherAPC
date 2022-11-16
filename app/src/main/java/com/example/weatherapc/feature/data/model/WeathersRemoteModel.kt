package com.example.weatherapc.feature.data.model

import com.google.gson.annotations.SerializedName

data class WeathersRemoteModel(
    @SerializedName("main")
    val weatherList: List<WeatherRemoteModel>
//    @SerializedName("wind")
//    val wind: WeatherRemoteModel
)
