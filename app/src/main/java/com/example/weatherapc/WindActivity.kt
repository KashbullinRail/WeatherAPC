package com.example.weatherapc

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.weatherapc.featureWind.weather_screen.ui.UIEvent
import com.example.weatherapc.featureWind.weather_screen.ui.ViewState
import com.example.weatherapc.featureWind.weather_screen.ui.WeatherScreenViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel

class WindActivity(): AppCompatActivity() {

    private val viewModelWind: WeatherScreenViewModel by viewModel()

    private val tvSpeed : TextView by lazy { findViewById(R.id.tvSpeed) }
    private val tvDeg: TextView by lazy { findViewById(R.id.tvDeg) }

    private val progressBar : ProgressBar by lazy { findViewById(R.id.progressBar)}
    private val fabWeatherWind : FloatingActionButton by lazy { findViewById(R.id.fabWeatherFetchWind)}
    private val fabWeatherTempAction: FloatingActionButton by lazy { findViewById(R.id.fabWeatherTempAction) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wind)

        viewModelWind.viewState.observe(this,::render)

        fabWeatherWind.setOnClickListener {
            viewModelWind.processUIEvent(UIEvent.onButtonClickedWind)
        }

        fabWeatherTempAction.setOnClickListener{
            val tempActivityAction = Intent(this, MainActivity::class.java)
            startActivity(tempActivityAction)
        }

    }

    private fun render(viewState: ViewState){
        progressBar.isVisible = viewState.isLoading
        tvSpeed.text = "${viewState.titleSpeed} ${viewState.speed}"
        tvDeg.text = "${viewState.titleDeg} ${viewState.deg}"

    }

}