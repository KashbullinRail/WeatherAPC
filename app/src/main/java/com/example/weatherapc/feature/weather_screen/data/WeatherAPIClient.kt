package com.example.weatherapc.feature.weather_screen.data

import com.example.weatherapc.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object WeatherAPIClient {

    private val okHttpClient = OkHttpClient.Builder()
        .build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private val weatherAPI = retrofit.create(WeatherAPI::class.java)
    fun getAPI(): WeatherAPI {
        return weatherAPI

    }
}