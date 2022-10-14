package com.example.weatherapc.feature.mainscreen


import com.example.weatherapc.base.Event

data class ViewState(
    val isLoading: Boolean,
    val temperature: String,
    val pressure: String,
    val humidity: String,
//    val titleTemp: String,
//    val titlePressure: String,
//    val titleHumidity: String,
    val speed: String,
    val deg: String,
//    val titleSpeed: String,
//    val titleDeg: String
)

sealed class UIEvent : Event {
    object onButtonClickedMain : UIEvent()
}


sealed class DataEvent : Event {
    object LoadWeather : DataEvent()
    data class onWeatherFetchMainSucceed(
        val temperature: String,
        val pressure: String,
        val humidity: String,
        val speed: String,
        val deg: String
    ) : DataEvent()

    data class onWeatherFetchMainFailed(val error: Throwable) : DataEvent()

}
