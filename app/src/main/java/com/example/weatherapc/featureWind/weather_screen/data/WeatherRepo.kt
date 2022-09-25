package com.example.weatherapc.featureWind.weather_screen.data

import com.example.weatherapc.featureWind.weather_screen.ui.model.WeatherModel


interface WeatherRepo {
    suspend fun getSpeed(): WeatherModel
    suspend fun getDeg(): WeatherModel
}