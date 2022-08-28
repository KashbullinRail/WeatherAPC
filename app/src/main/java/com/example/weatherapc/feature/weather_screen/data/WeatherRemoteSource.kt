package com.example.weatherapc.feature.weather_screen.data

import retrofit2.Response

class WeatherRemoteSource(private val api: WeatherAPI) {

    // TODO add query
    fun getWeather(): Response<String> {
        return api.getWeather(query = "Moscow")
    }
}