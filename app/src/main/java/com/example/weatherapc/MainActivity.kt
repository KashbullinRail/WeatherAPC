package com.example.weatherapc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.weatherapc.feature.weather_screen.ui.UIEvent
import com.example.weatherapc.feature.weather_screen.ui.ViewState
import com.example.weatherapc.feature.weather_screen.ui.WeatherScreenViewModel
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.abs


class MainActivity() : AppCompatActivity() {

    private val viewModel: WeatherScreenViewModel by viewModel()

    private val tvHello : TextView by lazy { findViewById(R.id.tVHello) }
    private val fabWeather : FloatingActionButton by lazy { findViewById(R.id.fabWeatherFetch)}
    private val progressBar : ProgressBar by lazy { findViewById(R.id.progressBar)}
    private val collapsingToolbar : CollapsingToolbarLayout by lazy { findViewById(R.id.collapsingToolbar)}
    private val filmAppBar : AppBarLayout by lazy { findViewById(R.id.filmAppBar)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.viewState.observe(this,::render)

        filmAppBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener{appBarLayout, verticalOffset ->
            val percent =
                (abs(appBarLayout.totalScrollRange + verticalOffset).toFloat()/appBarLayout.totalScrollRange)
            fabWeather.alpha = percent
            Log.d("Percent", "$percent")
        })

        fabWeather.setOnClickListener {
            viewModel.processUIEvent(UIEvent.onButtonClicked)
        }

    }

    private fun render(viewState: ViewState){
        progressBar.isVisible = viewState.isLoading
        collapsingToolbar.title = viewState.temperature
        tvHello.text = "${viewState.title} ${viewState.temperature}"
    }

}