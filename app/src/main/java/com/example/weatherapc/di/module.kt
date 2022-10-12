package com.example.weatherapc.di

import com.example.weatherapc.featureTemp.weather_screen.data.WeatherAPI
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val API_KEY = "9ba2ce61cb10f2189007b0331863bb3a"
const val BASE_URL = "https://api.openweathermap.org/data/2.5/"


val networkModuleMain = module {

    single<OkHttpClient> {
        OkHttpClient
            .Builder()
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(com.example.weatherapc.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }

    single<WeatherAPI> {
        get<Retrofit>()
            .create(WeatherAPI::class.java)
    }

}