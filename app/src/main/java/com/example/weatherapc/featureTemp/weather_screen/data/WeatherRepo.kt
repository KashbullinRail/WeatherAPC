package com.example.weatherapc.featureTemp.weather_screen.data

import com.example.weatherapc.featureTemp.weather_screen.ui.model.WeatherModel

interface WeatherRepo {

    suspend fun getTemperature(): WeatherModel
}