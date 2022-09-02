package com.example.weatherapc.feature.weather_screen.ui

import androidx.lifecycle.ViewModel
import com.example.weatherapc.base.BaseViewModel
import com.example.weatherapc.base.Event
import com.example.weatherapc.feature.weather_screen.WeatherInteractor

class WeatherScreenViewModel(val interactor : WeatherInteractor): BaseViewModel<ViewState>() {
    suspend fun getWeather():String {
        return interactor.getWeather()
    }

    override fun initialViewState(): ViewState = ViewState(title = "Hello",temperature = "")

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when(event){
            is UIEvent.onButtonClicked -> {
                val temperature = getWeather()
                return previousState.copy(temperature = temperature)
            }
            else -> return null
        }
    }
}