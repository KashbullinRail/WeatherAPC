package com.example.weatherapc.featureWind.weather_screen.di

import com.example.weatherapc.BASE_URL
import com.example.weatherapc.featureWind.weather_screen.WeatherInteractorWind
import com.example.weatherapc.featureWind.weather_screen.data.WeatherAPI
import com.example.weatherapc.featureWind.weather_screen.data.WeatherRemoteSourceWind
import com.example.weatherapc.featureWind.weather_screen.data.WeatherRepoImplWind
import com.example.weatherapc.featureWind.weather_screen.data.WeatherRepoWind
import com.example.weatherapc.featureWind.weather_screen.ui.WeatherScreenViewModelWind
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherScreenModuleWind = module {

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

    single<WeatherRemoteSourceWind> { WeatherRemoteSourceWind(get<WeatherAPI>()) }

    single<WeatherRepoWind> { WeatherRepoImplWind(get<WeatherRemoteSourceWind>()) }

    single<WeatherInteractorWind> { WeatherInteractorWind(get<WeatherRepoWind>()) }

    viewModel { WeatherScreenViewModelWind(get<WeatherInteractorWind>()) }

}