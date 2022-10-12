package com.example.weatherapc

import android.app.Application
import com.example.weatherapc.feature.di.weatherScreenViewModel
import com.example.weatherapc.featureTemp.weather_screen.di.weatherScreenModuleMain
import com.example.weatherapc.featureWind.weather_screen.di.weatherScreenModuleWind
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(weatherScreenModuleMain, weatherScreenModuleWind, weatherScreenViewModel)
        }
    }
}