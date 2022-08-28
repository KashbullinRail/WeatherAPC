package com.example.weatherapc

import retrofit2.http.GET


interface WeatherAPI {

    @GET("")
    fun getWeather(){

    }

}