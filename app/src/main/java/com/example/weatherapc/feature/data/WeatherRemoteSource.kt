package com.example.weatherapc.feature.data

import com.example.weatherapc.feature.data.model.WeatherRemoteModel
import com.example.weatherapc.spCityChoice


class WeatherRemoteSource(private val api: WeatherAPI) {

    suspend fun getWeather(): WeatherRemoteModel {
        return api.getWeather(query = "Kazan")
    }
}
