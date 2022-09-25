package com.example.weatherapc.featureTemp.weather_screen.data

import com.example.weatherapc.featureTemp.weather_screen.data.model.WeatherRemoteModel

class WeatherRemoteSource(private val api: WeatherAPI) {

    suspend fun getWeather(): WeatherRemoteModel {
        return api.getWeather(query = "Kazan")
    }
}