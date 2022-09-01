package com.example.weatherapc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.weatherapc.feature.weather_screen.WeatherInteractor
import com.example.weatherapc.feature.weather_screen.data.WeatherAPI
import com.example.weatherapc.feature.weather_screen.data.WeatherAPIClient
import com.example.weatherapc.feature.weather_screen.data.WeatherRemoteSource
import com.example.weatherapc.feature.weather_screen.data.WeatherRepoImpl
import com.example.weatherapc.feature.weather_screen.ui.WeatherScreenPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity() : AppCompatActivity() {

    private lateinit var presenter : WeatherScreenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = WeatherScreenPresenter(
            WeatherInteractor(
                WeatherRepoImpl(
                    WeatherRemoteSource(WeatherAPIClient.getAPI())
                )
            )
        )
        var weather = ""
        val tvTemp = findViewById<TextView>(R.id.tVHello)

        GlobalScope.launch {
            withContext(Dispatchers.Main){
                tvTemp.text = presenter.getWeather()
            }
        }
    }
}