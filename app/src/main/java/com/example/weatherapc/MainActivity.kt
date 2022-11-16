package com.example.weatherapc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import com.example.weatherapc.databinding.ActivityMainBinding
import com.example.weatherapc.featureTemp.weather_screen.ui.State
import com.example.weatherapc.featureTemp.weather_screen.ui.UIEvent
import com.example.weatherapc.featureTemp.weather_screen.ui.ViewState
import com.example.weatherapc.featureTemp.weather_screen.ui.WeatherScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity() : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherScreenViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        choiseSpinner()

        viewModel.viewState.observe(this, ::render)

        binding.fabWeatherFetchTemp.setOnClickListener {
            viewModel.processUIEvent(UIEvent.onButtonClickedMain)
        }

        binding.fabWeatherWindAction.setOnClickListener {
            val windActivityAction = Intent(this, WindActivity::class.java)
            startActivity(windActivityAction)
        }
    }

    private fun render(viewState: ViewState) {
        when (viewState.state) {
            State.Load -> {

            }
            State.Content -> {
                with(binding) {
                    progressBar.isVisible = viewState.isLoading
                    tvTemp.text = "${viewState.titleTemp} ${viewState.temperature}"
                    tvPressure.text = "${viewState.titlePressure} ${viewState.pressure}"
                    tvHumidity.text = "${viewState.titleHumidity} ${viewState.humidity}"
                }
            }
            State.Error -> {
                Log.e("ERROR", "error render MainActivity")
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

