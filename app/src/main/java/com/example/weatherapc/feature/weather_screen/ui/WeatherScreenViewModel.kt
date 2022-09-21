package com.example.weatherapc.feature.weather_screen.ui

import androidx.lifecycle.viewModelScope
import com.example.weatherapc.base.BaseViewModel
import com.example.weatherapc.base.Event
import com.example.weatherapc.feature.weather_screen.WeatherInteractor
import kotlinx.coroutines.launch


class WeatherScreenViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {


    override fun initialViewState(): ViewState =
        ViewState(isLoading = false, title = "Температура воздуха ", temperature = "нажмите кнопку для запроса")

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.onButtonClicked -> {

                viewModelScope.launch {
                    interactor.getWeather().fold(
                        onError = {
                            processDataEvent(DataEvent.onWeatherFetchFailed(error = it))
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.onWeatherFetchSucceed(temperature = it.temperature))
                        }
                    )
                }

                return previousState.copy(isLoading = true)
            }
            is DataEvent.onWeatherFetchSucceed -> {
                return previousState.copy(isLoading = false, temperature = event.temperature)
            }

            else -> return null
        }
    }
}