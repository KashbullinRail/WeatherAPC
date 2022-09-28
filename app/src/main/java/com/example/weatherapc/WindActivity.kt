package com.example.weatherapc

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.weatherapc.featureWind.weather_screen.ui.UIEventWind
import com.example.weatherapc.featureWind.weather_screen.ui.ViewStateWind
import com.example.weatherapc.featureWind.weather_screen.ui.WeatherScreenViewModelWind
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel

class WindActivity(): AppCompatActivity() {

    private val viewModelWind: WeatherScreenViewModelWind by viewModel()

    private val tvSpeed : TextView by lazy { findViewById(R.id.tvSpeed) }
    private val tvDeg: TextView by lazy { findViewById(R.id.tvDeg) }

    private val progressBarWind : ProgressBar by lazy { findViewById(R.id.progressBarWind)}
    private val fabWeatherWind : FloatingActionButton by lazy { findViewById(R.id.fabWeatherFetchWind)}
    private val fabWeatherTempAction: FloatingActionButton by lazy { findViewById(R.id.fabWeatherTempAction) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wind)

        viewModelWind.viewState.observe(this,::render)

        fabWeatherWind.setOnClickListener {
            viewModelWind.processUIEvent(UIEventWind.onButtonClickedWind)
        }

        fabWeatherTempAction.setOnClickListener{
            val tempActivityAction = Intent(this, MainActivity::class.java)
            startActivity(tempActivityAction)
        }

    }

    private fun render(viewState: ViewStateWind){
        progressBarWind.isVisible = viewState.isLoading
        tvSpeed.text = "${viewState.titleSpeed} ${viewState.speed}"
        tvDeg.text = "${viewState.titleDeg} ${viewState.deg}"

    }

}