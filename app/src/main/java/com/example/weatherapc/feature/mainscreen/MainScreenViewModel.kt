package com.example.weatherapc.feature.mainscreen

import androidx.lifecycle.viewModelScope
import com.example.weatherapc.base.BaseViewModel
import com.example.weatherapc.base.Event
import com.example.weatherapc.feature.domain.WeatherInteractor
import kotlinx.coroutines.launch


class MainScreenViewModel(private val interactor: WeatherInteractor) :
    BaseViewModel<ViewState>() {

//    init {
//        processDataEvent(DataEvent.LoadWeather)
//    }


    override fun initialViewState(): ViewState =
        ViewState(
            isLoading = false,
//            titleTemp = "Температура воздуха  ",
//            titlePressure = "Атмосферное давление  ",
//            titleHumidity = "Влажность воздуха  ",
            temperature = "?",
            pressure = "?",
            humidity = "?",
            speed = "?",
            deg = "?",
//            titleSpeed = "Скорость ветра  ",
//            titleDeg = "Направление ветра  "
        )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.LoadWeather -> {

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
                                    humidity = it.humidity,
                                    speed = it.speed,
                                    deg = it.deg
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
                    humidity = event.humidity,
                    speed = event.speed,
                    deg = event.deg
                )
            }

            else -> return null
        }
    }
}