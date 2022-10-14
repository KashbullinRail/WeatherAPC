package com.example.weatherapc.feature.data

import com.example.weatherapc.feature.domain.WeatherModel


interface WeatherRepository {

    suspend fun getTemperature(): WeatherModel
    suspend fun getPressure(): WeatherModel
    suspend fun getHumidity(): WeatherModel
    suspend fun getSpeed(): WeatherModel
    suspend fun getDeg(): WeatherModel
}