package com.example.weatherapc.feature.mainscreen

import androidx.lifecycle.viewModelScope
import com.example.weatherapc.base.BaseViewModel
import com.example.weatherapc.base.Event
import com.example.weatherapc.featureTemp.weather_screen.WeatherInteractor
import kotlinx.coroutines.launch


class WeatherScreenViewModel(private val interactor: WeatherInteractor) :
    BaseViewModel<ViewState>() {


    override fun initialViewState(): ViewState =
        ViewState(
            isLoading = false,
            titleTemp = "Температура воздуха  ",
            titlePressure = "Атмосферное давление  ",
            titleHumidity = "Влажность воздуха  ",
            temperature = "?",
            pressure = "?",
            humidity = "?"
        )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.onButtonClickedMain -> {

                viewModelScope.launch {
                    interactor.getWeather().fold(
                        onError = {
                            processDataEvent(DataEvent.onWeatherFetchMainFailed(error = it))
                        },
                        onSuccess = {
                            processDataEvent(
                                DataEvent.onWeatherFetchMainSucceed(
                                    temperature = it.temperature,
                                    pressure = it.pressure,
                                    humidity = it.humidity
                                )
                            )
                        }
                    )
                }

                return previousState.copy(isLoading = true)
            }
            is DataEvent.onWeatherFetchMainSucceed -> {
                return previousState.copy(
                    isLoading = false,
                    temperature = event.temperature,
                    pressure = event.pressure,
                    humidity = event.humidity
                )
            }

            else -> return null
        }
    }
}