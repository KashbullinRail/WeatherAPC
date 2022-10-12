package com.example.weatherapc.feature.data

import com.example.weatherapc.featureTemp.weather_screen.ui.model.WeatherModel

interface WeatherRepo {

    suspend fun getTemperature(): WeatherModel
    suspend fun getPressure(): WeatherModel
    suspend fun getHumidity(): WeatherModel
}