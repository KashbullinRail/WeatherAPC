package com.example.weatherapc.featureWind.weather_screen.ui

import androidx.lifecycle.viewModelScope
import com.example.weatherapc.base.BaseViewModel
import com.example.weatherapc.base.Event
import com.example.weatherapc.featureWind.weather_screen.WeatherInteractor

import kotlinx.coroutines.launch

class WeatherScreenViewModel(private val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {


    override fun initialViewState(): ViewState =
        ViewState(
            isLoading = false,
            speed = "?",
            deg = "?",
            titleSpeed = "Скорость ветра  ",
            titleDeg = "Направление ветра  "
        )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.onButtonClickedWind -> {

                viewModelScope.launch {
                    interactor.getWeather().fold(
                        onError = {
                            processDataEvent(DataEvent.onWeatherFetchWindFailed(error = it))
                        },
                        onSuccess = {
                            processDataEvent(
                                DataEvent.onWeatherFetchWindSucceed(
                                    speed = it.speed,
                                    deg = it.deg
                                )
                            )
                        }
                    )
                }

                return previousState.copy(isLoading = true)
            }
            is DataEvent.onWeatherFetchWindSucceed -> {
                return previousState.copy(
                    isLoading = false,
                    speed = event.speed,
                    deg = event.deg
                )
            }

            else -> return null
        }
    }
}