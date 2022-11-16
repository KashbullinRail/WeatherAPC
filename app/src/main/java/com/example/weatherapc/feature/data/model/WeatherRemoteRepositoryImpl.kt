package com.example.weatherapc.feature.data.model

import com.example.weatherapc.feature.data.WeatherRemoteSource
import com.example.weatherapc.feature.data.WeatherRepository
import com.example.weatherapc.feature.data.toDomian
import com.example.weatherapc.feature.domain.WeatherModel


class WeatherRemoteRepositoryImpl(private val source: WeatherRemoteSource) : WeatherRepository {

    override suspend fun getWeather(): List<WeatherModel> {
        return source.getWeather().weatherList.map {
            it.toDomian()
        }
    }
}