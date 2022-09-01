package com.example.weatherapc.feature.weather_screen.data

class WeatherRepoMock : WeatherRepo {
    override suspend fun getTemperature(): String = "Подделки"
}