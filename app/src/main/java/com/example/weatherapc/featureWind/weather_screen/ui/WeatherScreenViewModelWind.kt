package com.example.weatherapc.featureWind.weather_screen.ui

import androidx.lifecycle.viewModelScope
import com.example.weatherapc.base.BaseViewModel
import com.example.weatherapc.base.Event
import com.example.weatherapc.featureWind.weather_screen.WeatherInteractorWind
import kotlinx.coroutines.launch

class WeatherScreenViewModelWind(private val interactorWind: WeatherInteractorWind) :
    BaseViewModel<ViewStateWind>() {


    override fun initialViewState() = ViewStateWind(
        state = State.Load,
        isLoading = false,
        speed = "?",
        deg = "?",
        titleSpeed = "Скорость ветра  ",
        titleDeg = "Направление ветра  "
    )

    override fun reduce(event: Event, previousState: ViewStateWind): ViewStateWind? {
        when (event) {
            is UIEventWind.onButtonClickedWind -> {
                viewModelScope.launch {
                    interactorWind.getWeather().fold(
                        onError = {
                            processDataEvent(DataEventWind.onWeatherFetchWindFailed(error = it))
                        },
                        onSuccess = {
                            processDataEvent(
                                DataEventWind.onWeatherFetchWindSucceed(
                                    speed = it.speed,
                                    deg = it.deg
                                )
                            )
                        }
                    )
                }

                return previousState.copy(isLoading = true)
            }
            is DataEventWind.onWeatherFetchWindSucceed -> {
                return previousState.copy(
                    isLoading = false,
                    speed = event.speed,
                    deg = event.deg,
                    state = State.Content
                )
            }

            else -> return null
        }
    }
}