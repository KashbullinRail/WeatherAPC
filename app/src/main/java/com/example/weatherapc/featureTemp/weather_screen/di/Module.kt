package com.example.weatherapc.featureTemp.weather_screen.di

import com.example.weatherapc.BASE_URL
import com.example.weatherapc.featureTemp.weather_screen.WeatherInteractor
import com.example.weatherapc.featureTemp.weather_screen.data.WeatherAPI
import com.example.weatherapc.featureTemp.weather_screen.data.WeatherRemoteSource
import com.example.weatherapc.featureTemp.weather_screen.data.WeatherRepo
import com.example.weatherapc.featureTemp.weather_screen.data.WeatherRepoImpl
import com.example.weatherapc.featureTemp.weather_screen.ui.WeatherScreenViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherScreenModule = module {

    single<OkHttpClient> {
        OkHttpClient
            .Builder()
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }

    single<WeatherAPI> {
        get<Retrofit>()
            .create(WeatherAPI::class.java)
    }

    single<WeatherRemoteSource> { WeatherRemoteSource(get<WeatherAPI>()) }

    single<WeatherRepo> { WeatherRepoImpl(get<WeatherRemoteSource>()) }

    single<WeatherInteractor> { WeatherInteractor(get<WeatherRepo>()) }

    viewModel { WeatherScreenViewModel(get<WeatherInteractor>()) }


}