package com.example.weatherapc.feature.weather_screen.di

import com.example.weatherapc.BASE_URL
import com.example.weatherapc.feature.weather_screen.WeatherInteractor
import com.example.weatherapc.feature.weather_screen.data.*
import com.example.weatherapc.feature.weather_screen.ui.WeatherScreenPresenter
import okhttp3.OkHttpClient
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

//    single<WeatherRepo> { WeatherRepoImpl(get<WeatherRemoteSource>()) }

    single<WeatherRepo> { WeatherRepoMock() }

    single<WeatherInteractor> { WeatherInteractor(get<WeatherRepo>()) }

    single { WeatherScreenPresenter(get<WeatherInteractor>()) }


}