package com.example.weatherapc.featureWind.weather_screen.data


import com.example.weatherapc.featureWind.weather_screen.data.model.WeatherRemoteModelWind
import com.example.weatherapc.spCityChoice


class WeatherRemoteSourceWind(private val api: WeatherAPI) {

    suspend fun getWeather(): WeatherRemoteModelWind {
        return api.getWeather(query = spCityChoice)
    }
}