package com.example.weatherapc.feature.mainscreen

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.weatherapc.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainScreenFragment : Fragment(R.layout.fragment_main_screen) {


    private val viewModel: MainScreenViewModel by viewModel()

    private val tvTemp: TextView by lazy { requireActivity().findViewById(R.id.tvTemp) }
    private val tvPressure: TextView by lazy { requireActivity().findViewById(R.id.tvPressure) }
    private val tvHumidity: TextView by lazy { requireActivity().findViewById(R.id.tvHumidity) }
    private val tvSpeed: TextView by lazy { requireActivity().findViewById(R.id.tvSpeed) }
    private val tvDeg: TextView by lazy { requireActivity().findViewById(R.id.tvDeg) }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModel.viewState.observe(viewLifecycleOwner, ::render)

    }

    private fun render(viewState: ViewState) {
        when(viewState.state){
            State.Load -> {
                tvTemp.text = "???"
                tvPressure.text = "???"
                tvHumidity.text = "???"
                tvDeg.text = "???"
                tvSpeed.text = "???"

            }

            State.Content -> {
                viewState.weatherList
            }

            State.Error -> {

            }

        }
    }

}



