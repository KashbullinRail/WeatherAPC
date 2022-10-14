package com.example.weatherapc.feature.data.model

import com.example.weatherapc.feature.data.WeatherRemoteSource
import com.example.weatherapc.feature.data.WeatherRepository
import com.example.weatherapc.feature.data.toDomian
import com.example.weatherapc.feature.domain.WeatherModel


class WeatherRemoteRepositoryImpl(private val source: WeatherRemoteSource) : WeatherRepository {

    override suspend fun getTemperature(): WeatherModel {
        return source.getWeather().toDomian()
    }

    override suspend fun getPressure(): WeatherModel {
        return source.getWeather().toDomian()
    }

    override suspend fun getHumidity(): WeatherModel {
        return source.getWeather().toDomian()
    }

    override suspend fun getSpeed(): WeatherModel {
        return source.getWeather().toDomian()
    }

    override suspend fun getDeg(): WeatherModel {
        return source.getWeather().toDomian()
    }

}