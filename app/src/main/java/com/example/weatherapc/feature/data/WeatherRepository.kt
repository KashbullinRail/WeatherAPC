package com.example.weatherapc.feature.data

import com.example.weatherapc.feature.domain.WeatherModel


interface WeatherRepository {
    suspend fun getWeather(): List<WeatherModel>
}