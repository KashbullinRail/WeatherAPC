package com.example.weatherapc.featureWind.weather_screen

import com.example.weatherapc.base.Either
import com.example.weatherapc.base.attempt
import com.example.weatherapc.featureWind.weather_screen.data.WeatherRepoWind
import com.example.weatherapc.featureWind.weather_screen.ui.model.WeatherModelWind


class WeatherInteractorWind(private val weatherRepoWind: WeatherRepoWind) {

    suspend fun getWeather(): Either<Throwable, WeatherModelWind> {
        return attempt { weatherRepoWind.getSpeed() }
    }


}