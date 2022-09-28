package com.example.weatherapc.featureWind.weather_screen.ui

import com.example.weatherapc.base.Event


data class ViewStateWind(
    val isLoading : Boolean,
    val speed : String,
    val deg: String,
    val titleSpeed : String,
    val titleDeg: String,
)

sealed class UIEventWind : Event {
    object onButtonClickedWind : UIEventWind()
}

sealed class DataEventWind : Event {
    data class onWeatherFetchWindSucceed(val speed: String, val deg: String) : DataEventWind()
    data class onWeatherFetchWindFailed(val error: Throwable) : DataEventWind()
}