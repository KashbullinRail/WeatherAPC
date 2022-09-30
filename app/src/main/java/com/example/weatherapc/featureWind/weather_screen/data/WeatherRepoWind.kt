package com.example.weatherapc.featureWind.weather_screen.data

import com.example.weatherapc.featureWind.weather_screen.ui.model.WeatherModelWind


interface WeatherRepoWind {
    suspend fun getSpeed(): WeatherModelWind
    suspend fun getDeg(): WeatherModelWind
}