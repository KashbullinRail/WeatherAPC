package com.example.weatherapc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.weatherapc.feature.weather_screen.ui.WeatherScreenPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject


class MainActivity() : AppCompatActivity() {

    private val presenter: WeatherScreenPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvTemp = findViewById<TextView>(R.id.tVHello)

        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                tvTemp.text = presenter.getWeather()
            }
        }
    }
}