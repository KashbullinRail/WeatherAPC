package com.example.weatherapc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
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

    private val tvHello : TextView by lazy { findViewById(R.id.tVTemp) }
    private val fabWeather : FloatingActionButton by lazy { findViewById(R.id.fabWeatherFetchTemp)}
    private val progressBar : ProgressBar by lazy { findViewById(R.id.progressBar)}
    private val fabWeatherWindAction: FloatingActionButton by lazy { findViewById(R.id.fabWeatherWindAction) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.viewState.observe(this,::render)

        fabWeather.setOnClickListener {
            viewModel.processUIEvent(UIEvent.onButtonClicked)
        }

        fabWeatherWindAction.setOnClickListener{
            val windActivityAction = Intent(this, WindActivity::class.java)
            startActivity(windActivityAction)
        }


    }

    private fun render(viewState: ViewState){
        progressBar.isVisible = viewState.isLoading
        tvHello.text = "${viewState.title} ${viewState.temperature}"
    }

}