package com.example.weatherapc.feature.mainscreen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.weatherapc.base.BaseViewModel
import com.example.weatherapc.base.Event
import com.example.weatherapc.feature.domain.WeatherInteractor
import com.example.weatherapc.feature.domain.WeatherModel
import kotlinx.coroutines.launch


class MainScreenViewModel(private val interactor: WeatherInteractor) :
    BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadWeather)
    }

    override fun initialViewState() = ViewState (
        state = State.Load,
        weatherList = emptyList()
        )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.LoadWeather -> {
                viewModelScope.launch {
                    interactor.getWeather().fold(
                        onError = {
                            Log.e("ERROR", it.localizedMessage)
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.onWeatherFetchMainSucceed(it))
                        }
                    )
                }
                return null
            }
            is DataEvent.onWeatherFetchMainSucceed -> {
                return previousState.copy(
                    weatherList = event.weather,
                    state = State.Content
                )
            }
            else -> return null
        }
    }
}