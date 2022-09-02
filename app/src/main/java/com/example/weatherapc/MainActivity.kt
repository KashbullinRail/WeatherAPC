package com.example.weatherapc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.weatherapc.feature.weather_screen.ui.UIEvent
import com.example.weatherapc.feature.weather_screen.ui.ViewState
import com.example.weatherapc.feature.weather_screen.ui.WeatherScreenViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity() : AppCompatActivity() {

    private val viewModel: WeatherScreenViewModel by viewModel()

    private val tvHello : TextView by lazy { findViewById(R.id.tVHello) }
    private val fabWeather : FloatingActionButton by lazy { findViewById(R.id.fabWeatherFetch)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.viewState.observe(this,::render)

        fabWeather.setOnClickListener {
            viewModel.processUIEvent(UIEvent.onButtonClicked)
        }

    }

    private fun render(viewState: ViewState){
        tvHello.text = "${viewState.title} ${viewState.temperature}"
    }

}