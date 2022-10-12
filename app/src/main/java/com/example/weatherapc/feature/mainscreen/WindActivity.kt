package com.example.weatherapc.feature.mainscreen

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.weatherapc.MainActivity
import com.example.weatherapc.R
import com.example.weatherapc.featureWind.weather_screen.ui.UIEventWind
import com.example.weatherapc.featureWind.weather_screen.ui.ViewStateWind
import com.example.weatherapc.featureWind.weather_screen.ui.WeatherScreenViewModelWind
import com.example.weatherapc.spCityChoice
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainScreenFragment : Fragment(R.layout.activity_wind), AdapterView.OnItemSelectedListener {

    private val viewModelWind: WeatherScreenViewModelWind by viewModel()

    private val tvSpeed: TextView by lazy { requireActivity().findViewById(R.id.tvSpeed) }
    private val tvDeg: TextView by lazy { requireActivity().findViewById(R.id.tvDeg) }

    private val progressBarWind: ProgressBar by lazy { requireActivity().findViewById(R.id.progressBarWind) }
    private val fabWeatherWind: FloatingActionButton by lazy { requireActivity().findViewById(R.id.fabWeatherFetchWind) }
    private val fabWeatherTempAction: FloatingActionButton by lazy { requireActivity().findViewById(R.id.fabWeatherTempAction) }

    private val spCity: Spinner by lazy { requireActivity().findViewById(R.id.spCity) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.city,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spCity.adapter = adapter
        spCity.onItemSelectedListener = this


        viewModelWind.viewState.observe(viewLifecycleOwner, ::render)

        fabWeatherWind.setOnClickListener {
            viewModelWind.processUIEvent(UIEventWind.onButtonClickedWind)
        }

        fabWeatherTempAction.setOnClickListener {
            val tempActivityAction = Intent(viewLifecycleOwner, MainActivity::class.java)
            startActivity(tempActivityAction)
        }
    }


    private fun render(viewState: ViewStateWind) {
        progressBarWind.isVisible = viewState.isLoading
        tvSpeed.text = "${viewState.titleSpeed} ${viewState.speed}"
        tvDeg.text = "${viewState.titleDeg} ${viewState.deg}"
    }


    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val city: String = parent?.getItemAtPosition(position).toString()
        spCityChoice = city
    }

}

