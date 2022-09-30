package com.example.weatherapc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import com.example.weatherapc.featureTemp.weather_screen.data.WeatherRemoteSource
import com.example.weatherapc.featureTemp.weather_screen.ui.UIEvent
import com.example.weatherapc.featureTemp.weather_screen.ui.ViewState
import com.example.weatherapc.featureTemp.weather_screen.ui.WeatherScreenViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity() : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private val viewModel: WeatherScreenViewModel by viewModel()

    private val tvTemp: TextView by lazy { findViewById(R.id.tvTemp) }
    private val tvPressure: TextView by lazy { findViewById(R.id.tvPressure) }
    private val tvHumidity: TextView by lazy { findViewById(R.id.tvHumidity) }

    private val progressBar: ProgressBar by lazy { findViewById(R.id.progressBar) }
    private val fabWeatherMain: FloatingActionButton by lazy { findViewById(R.id.fabWeatherFetchTemp) }
    private val fabWeatherWindAction: FloatingActionButton by lazy { findViewById(R.id.fabWeatherWindAction) }

    private val spCity: Spinner by lazy { findViewById(R.id.spCity) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.city,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spCity.adapter = adapter
        spCity.onItemSelectedListener = this


        viewModel.viewState.observe(this, ::render)

        fabWeatherMain.setOnClickListener {
            viewModel.processUIEvent(UIEvent.onButtonClickedMain)
        }

        fabWeatherWindAction.setOnClickListener {
            val windActivityAction = Intent(this, WindActivity::class.java)
            startActivity(windActivityAction)
        }
    }

    private fun render(viewState: ViewState) {
        progressBar.isVisible = viewState.isLoading
        tvTemp.text = "${viewState.titleTemp} ${viewState.temperature}"
        tvPressure.text = "${viewState.titlePressure} ${viewState.pressure}"
        tvHumidity.text = "${viewState.titleHumidity} ${viewState.humidity}"
    }


    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val city: String = parent?.getItemAtPosition(position).toString()
        spCityChoice = city
    }

}

