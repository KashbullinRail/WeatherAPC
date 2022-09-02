package com.example.weatherapc.feature.weather_screen.ui

import com.example.weatherapc.base.Event

data class ViewState(
    val temperature : String
)

sealed class UIEvent : Event {
    object onButtonClicked : UIEvent()
}