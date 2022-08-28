package com.example.weatherapc

import okhttp3.OkHttpClient
import retrofit2.Retrofit


object WeatherAPIClient {

    private val okHttpClient = OkHttpClient.Builder()
        .build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    fun getAPI() {

    }
}