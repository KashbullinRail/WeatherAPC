package com.example.weatherapc.feature.di

import com.example.weatherapc.featureTemp.weather_screen.WeatherInteractor
import com.example.weatherapc.featureTemp.weather_screen.data.WeatherAPI
import com.example.weatherapc.featureTemp.weather_screen.data.WeatherRemoteSource
import com.example.weatherapc.featureTemp.weather_screen.data.WeatherRepo
import com.example.weatherapc.featureTemp.weather_screen.data.WeatherRepoImpl
import com.example.weatherapc.featureTemp.weather_screen.ui.WeatherScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val weatherScreenViewModel = module {

    single<WeatherAPI> {
        get<Retrofit>().create(WeatherAPI::class.java)
    }

    single<WeatherRemoteSource> {
        WeatherRemoteSource(api = get())
    }

    single<WeatherRepo> {
        WeatherRepoImpl(weatherRemoteSource = get())
    }

    single<WeatherInteractor> {
        WeatherInteractor(weatherRepo = get())
    }

    viewModel {
        WeatherScreenViewModel(interactor = get())
    }

}