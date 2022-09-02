package com.example.weatherapc.feature.weather_screen

import com.example.weatherapc.base.Either
import com.example.weatherapc.base.attempt
import com.example.weatherapc.feature.weather_screen.data.WeatherRepo
import com.example.weatherapc.feature.weather_screen.ui.model.WeatherModel

class WeatherInteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather(): Either<Throwable, WeatherModel> {
        return attempt { weatherRepo.getTemperature() }
    }
}