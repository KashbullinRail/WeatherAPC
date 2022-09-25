package com.example.weatherapc.featureWind.weather_screen.data

import com.example.weatherapc.featureWind.weather_screen.data.model.WeatherRemoteModel
import com.example.weatherapc.featureWind.weather_screen.ui.model.WeatherModel


fun WeatherRemoteModel.toDomian() = WeatherModel(
    speed = this.wind.speed,
    deg = this.wind.deg

)