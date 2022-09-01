package com.example.weatherapc.feature.weather_screen.data

interface WeatherRepo {

    suspend fun getTemperature(): String
}