package com.example.weatherapc.feature.weather_screen.ui

import androidx.lifecycle.ViewModel
import com.example.weatherapc.feature.weather_screen.WeatherInteractor

class WeatherScreenViewModel(val interactor : WeatherInteractor): ViewModel() {
    suspend fun getWeather():String {
        return interactor.getWeather()
    }
}