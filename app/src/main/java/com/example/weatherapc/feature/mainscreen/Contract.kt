package com.example.weatherapc.feature.mainscreen

import android.widget.Spinner
import com.example.weatherapc.base.Event

data class ViewState(
    val isLoading : Boolean,
    val temperature : String,
    val pressure: String,
    val humidity: String,
    val titleTemp : String,
    val titlePressure: String,
    val titleHumidity: String,
)

sealed class UIEvent : Event {
    object onButtonClickedMain : UIEvent()
}


sealed class DataEvent : Event {
    data class onWeatherFetchMainSucceed(val temperature: String, val pressure: String, val humidity: String) : DataEvent()
    data class onWeatherFetchMainFailed(val error: Throwable) : DataEvent()

}