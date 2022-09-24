package com.example.weatherapc.featureTemp.weather_screen.data

import com.example.weatherapc.featureTemp.weather_screen.data.model.WeatherRemoteModel
import com.example.weatherapc.featureTemp.weather_screen.ui.model.WeatherModel

fun WeatherRemoteModel.toDomian() = WeatherModel(
    temperature = this.main.temperature
)