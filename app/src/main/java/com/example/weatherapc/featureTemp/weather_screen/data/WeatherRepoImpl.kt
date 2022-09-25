package com.example.weatherapc.featureTemp.weather_screen.data

import com.example.weatherapc.featureTemp.weather_screen.ui.model.WeatherModel

class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {

    override suspend fun getTemperature(): WeatherModel {
        return weatherRemoteSource.getWeather().toDomian()
    }

    override suspend fun getPressure(): WeatherModel {
        return weatherRemoteSource.getWeather().toDomian()
    }

    override suspend fun getHumidity(): WeatherModel {
        return weatherRemoteSource.getWeather().toDomian()
    }

}