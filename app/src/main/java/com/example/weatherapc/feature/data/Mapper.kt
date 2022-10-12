package com.example.weatherapc.feature.data

import com.example.weatherapc.featureTemp.weather_screen.data.model.WeatherRemoteModel
import com.example.weatherapc.featureTemp.weather_screen.ui.model.WeatherModel

fun WeatherRemoteModel.toDomian() = WeatherModel(
    temperature = this.main.temperature,
    pressure = this.main.pressure,
    humidity = this.main.humidity
)