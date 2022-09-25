package com.example.weatherapc.featureWind.weather_screen.ui

import com.example.weatherapc.base.Event


data class ViewState(
    val isLoading : Boolean,
    val speed : String,
    val deg: String,
    val titleSpeed : String,
    val titleDeg: String,
)

sealed class UIEvent : Event {
    object onButtonClickedWind : UIEvent()
}

sealed class DataEvent : Event {
    data class onWeatherFetchWindSucceed(val speed: String, val deg: String) : DataEvent()
    data class onWeatherFetchWindFailed(val error: Throwable) : DataEvent()
}