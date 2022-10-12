package com.example.weatherapc.feature.domain

import com.example.weatherapc.base.attempt
import com.example.weatherapc.featureTemp.weather_screen.data.WeatherRepo



class WeatherInteractor(private val weatherRepo: WeatherRepo) {
    suspend fun getWeather() = attempt { weatherRepo.getTemperature() }

}