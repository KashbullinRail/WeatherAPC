package com.example.weatherapc

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.weatherapc.featureWind.weather_screen.ui.State
import com.example.weatherapc.featureWind.weather_screen.ui.UIEventWind
import com.example.weatherapc.featureWind.weather_screen.ui.ViewStateWind
import com.example.weatherapc.featureWind.weather_screen.ui.WeatherScreenViewModelWind
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel

class WindActivity() : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private val viewModelWind: WeatherScreenViewModelWind by viewModel()
    private val tvSpeed: TextView by lazy { findViewById(R.id.tvSpeed) }
    private val tvDeg: TextView by lazy { findViewById(R.id.tvDeg) }
    private val progressBarWind: ProgressBar by lazy { findViewById(R.id.progressBarWind) }
    private val fabWeatherWind: FloatingActionButton by lazy { findViewById(R.id.fabWeatherFetchWind) }
    private val fabWeatherTempAction: FloatingActionButton by lazy { findViewById(R.id.fabWeatherTempAction) }
    private val spCity: Spinner by lazy { findViewById(R.id.spCity) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wind)

        choiseSpinner()

        viewModelWind.viewState.observe(this, ::render)

        fabWeatherWind.setOnClickListener {
            viewModelWind.processUIEvent(UIEventWind.onButtonClickedWind)
        }

        fabWeatherTempAction.setOnClickListener {
            val tempActivityAction = Intent(this, MainActivity::class.java)
            startActivity(tempActivityAction)
        }
    }


    private fun render(viewState: ViewStateWind) {
        when(viewState.state) {
            State.Load -> {

            }

            State.Content ->{
                progressBarWind.isVisible = viewState.isLoading
                tvSpeed.text = "${viewState.titleSpeed } ${viewState.speed}"
                tvDeg.text = "${viewState.titleDeg} ${viewState.deg}"
            }

            State.Error -> {

            }

            }
    }


    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val city: String = parent?.getItemAtPosition(position).toString()
        spCityChoice = city
    }

    fun choiseSpinner() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.city,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spCity.adapter = adapter
        spCity.onItemSelectedListener = this
    }

}