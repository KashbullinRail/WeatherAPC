package com.example.weatherapc.feature.domain

import com.example.weatherapc.base.attempt
import com.example.weatherapc.feature.data.WeatherRepository


class WeatherInteractor(private val weatherRepo: WeatherRepository) {
    suspend fun getWeather() = attempt { weatherRepo.getTemperature() }

}