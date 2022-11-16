package com.example.weatherapc

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.weatherapc.databinding.ActivityWindBinding
import com.example.weatherapc.featureWind.weather_screen.ui.State
import com.example.weatherapc.featureWind.weather_screen.ui.UIEventWind
import com.example.weatherapc.featureWind.weather_screen.ui.ViewStateWind
import com.example.weatherapc.featureWind.weather_screen.ui.WeatherScreenViewModelWind
import org.koin.androidx.viewmodel.ext.android.viewModel

class WindActivity() : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityWindBinding
    private val viewModelWind: WeatherScreenViewModelWind by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityWindBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        choiseSpinner()

        viewModelWind.viewState.observe(this, ::render)

        binding.fabWeatherFetchWind.setOnClickListener {
            viewModelWind.processUIEvent(UIEventWind.onButtonClickedWind)
        }

        binding.fabWeatherTempAction.setOnClickListener {
            val tempActivityAction = Intent(this, MainActivity::class.java)
            startActivity(tempActivityAction)
        }
    }

    private fun render(viewState: ViewStateWind) {
        when (viewState.state) {
            State.Load -> {

            }
            State.Content -> {
                with(binding) {
                    progressBarWind.isVisible = viewState.isLoading
                    tvSpeed.text = "${viewState.titleSpeed} ${viewState.speed}"
                    tvDeg.text = "${viewState.titleDeg} ${viewState.deg}"
                }
            }
            State.Error -> {
                Log.e("ERROR", "error render WindActivity")
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
        binding.spCity.adapter = adapter
        binding.spCity.onItemSelectedListener = this
    }

}