package com.example.weatherapc.feature.data.model

import com.example.weatherapc.feature.data.WeatherRemoteSource
import com.example.weatherapc.feature.data.WeatherRepo
import com.example.weatherapc.feature.data.toDomian
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