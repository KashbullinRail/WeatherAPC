package com.example.weatherapc.featureTemp.weather_screen.ui

import android.widget.Spinner
import com.example.weatherapc.base.Event

enum class State {
    Load,
    Content,
    Error
}

data class ViewState(
    val isLoading: Boolean,
    val temperature: String,
    val pressure: String,
    val humidity: String,
    val titleTemp: String,
    val titlePressure: String,
    val titleHumidity: String,
)

sealed class UIEvent : Event {
    object onButtonClickedMain : UIEvent()
}


sealed class DataEvent : Event {
    data class onWeatherFetchMainSucceed(
        val temperature: String,
        val pressure: String,
        val humidity: String
    ) : DataEvent()

    data class onWeatherFetchMainFailed(val error: Throwable) : DataEvent()

}