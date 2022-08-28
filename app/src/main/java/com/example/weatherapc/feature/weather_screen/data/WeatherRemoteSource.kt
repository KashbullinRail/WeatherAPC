package com.example.weatherapc.feature.weather_screen.data

import com.example.weatherapc.feature.weather_screen.data.model.WeatherRemoteModel
import retrofit2.Response

class WeatherRemoteSource(private val api: WeatherAPI) {

    // TODO add query
    suspend fun getWeather(): WeatherRemoteModel {
        return api.getWeather(query = "Moscow")
    }
}