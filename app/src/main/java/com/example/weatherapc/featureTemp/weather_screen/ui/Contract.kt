package com.example.weatherapc.featureTemp.weather_screen.ui

import com.example.weatherapc.base.Event

data class ViewState(
    val isLoading : Boolean,
    val temperature : String,
    val title : String
)

sealed class UIEvent : Event {
    object onButtonClicked : UIEvent()
}

sealed class DataEvent : Event {
    data class onWeatherFetchSucceed(val temperature: String) : DataEvent()
    data class onWeatherFetchFailed(val error: Throwable) : DataEvent()

}