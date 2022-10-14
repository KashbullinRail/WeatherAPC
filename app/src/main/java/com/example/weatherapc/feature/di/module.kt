package com.example.weatherapc.feature.di

import com.example.weatherapc.feature.data.WeatherAPI
import com.example.weatherapc.feature.data.WeatherRemoteSource
import com.example.weatherapc.feature.data.WeatherRepository
import com.example.weatherapc.feature.data.model.WeatherRemoteRepositoryImpl
import com.example.weatherapc.feature.domain.WeatherInteractor
import com.example.weatherapc.feature.mainscreen.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val mainScreenModel = module {

    single<WeatherAPI> {
        get<Retrofit>().create(WeatherAPI::class.java)
    }

    single<WeatherRemoteSource> {
        WeatherRemoteSource(api = get())
    }

    single<WeatherRepository> {
        WeatherRemoteRepositoryImpl(source = get())
    }

    single<WeatherInteractor> {
        WeatherInteractor(weatherRepo = get())
    }

    viewModel {
        MainScreenViewModel(interactor = get())
    }

}