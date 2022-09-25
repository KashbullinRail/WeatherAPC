package com.example.weatherapc.featureWind.weather_screen.data


import com.example.weatherapc.featureWind.weather_screen.ui.model.WeatherModel


class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {

    override suspend fun getSpeed(): WeatherModel {
        return weatherRemoteSource.getWeather().toDomian()
    }

    override suspend fun getDeg(): WeatherModel {
        return weatherRemoteSource.getWeather().toDomian()
    }


}