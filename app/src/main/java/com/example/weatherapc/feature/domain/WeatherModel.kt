package com.example.weatherapc.feature.domain

data class WeatherModel(
    val isLoading : Boolean,
    val temperature : String,
    val pressure: String,
    val humidity: String,
    val titleTemp : String,
    val titlePressure: String,
    val titleHumidity: String,
)