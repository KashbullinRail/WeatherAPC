package com.example.weatherapc.featureWind.weather_screen.data

import com.example.weatherapc.API_KEY
import com.example.weatherapc.featureWind.weather_screen.data.model.WeatherRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("weather")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("units") units :String = "metric",
        @Query("appid") apiKey: String = API_KEY
    ): WeatherRemoteModel
}