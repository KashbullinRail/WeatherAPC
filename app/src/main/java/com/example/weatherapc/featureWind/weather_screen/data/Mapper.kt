package com.example.weatherapc.featureWind.weather_screen.data

import com.example.weatherapc.featureWind.weather_screen.data.model.WeatherRemoteModelWind
import com.example.weatherapc.featureWind.weather_screen.ui.model.WeatherModelWind


fun WeatherRemoteModelWind.toDomian() = WeatherModelWind(
    speed = this.wind.speed,
    deg = this.wind.deg

)