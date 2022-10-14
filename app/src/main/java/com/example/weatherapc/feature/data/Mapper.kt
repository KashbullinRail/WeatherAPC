package com.example.weatherapc.feature.data

import com.example.weatherapc.feature.data.model.WeatherRemoteModel
import com.example.weatherapc.feature.domain.WeatherModel


fun WeatherRemoteModel.toDomian() = WeatherModel(
    temperature = temperature ?: "",
    pressure = pressure ?: "",
    humidity = humidity ?: "",
    speed = speed ?: "",
    deg = deg ?: ""
)