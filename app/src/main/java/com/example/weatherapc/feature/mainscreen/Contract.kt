package com.example.weatherapc.feature.mainscreen


import com.example.weatherapc.base.Event
import com.example.weatherapc.feature.domain.WeatherModel

enum class State {
    Load,
    Content,
    Error
}

data class ViewState(
    val state: State,
    val weatherList: List<WeatherModel>
)

sealed class UIEvent : Event {
    object onButtonClickedMain : UIEvent()
}

sealed class DataEvent : Event {
    object LoadWeather : DataEvent()
    data class onWeatherFetchMainSucceed(val weather: List<WeatherModel>) : DataEvent()
//    data class onWeatherFetchMainFailed(val error: Throwable) : DataEvent()

}
