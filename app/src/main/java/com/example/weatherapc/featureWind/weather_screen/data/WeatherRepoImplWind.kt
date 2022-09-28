package com.example.weatherapc.featureWind.weather_screen.data


import com.example.weatherapc.featureWind.weather_screen.ui.model.WeatherModelWind


class WeatherRepoImplWind(private val weatherRemoteSourceWind: WeatherRemoteSourceWind) : WeatherRepoWind {

    override suspend fun getSpeed(): WeatherModelWind {
        return weatherRemoteSourceWind.getWeather().toDomian()
    }

    override suspend fun getDeg(): WeatherModelWind {
        return weatherRemoteSourceWind.getWeather().toDomian()
    }


}