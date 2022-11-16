package com.example.weatherapc.feature.data

import com.example.weatherapc.di.API_KEY
import com.example.weatherapc.feature.data.model.WeatherRemoteModel
import com.example.weatherapc.feature.data.model.WeathersRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherAPI {

    @GET("weather")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("units") units :String = "metric",
        @Query("appid") apiKey: String = API_KEY
    ): WeathersRemoteModel
}