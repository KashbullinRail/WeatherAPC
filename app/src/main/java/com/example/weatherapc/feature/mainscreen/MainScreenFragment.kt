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



//    private val adapter: ArticlesAdapter by lazy {
//        ArticlesAdapter { index ->
//            viewModel.processUIEvent(UIEvent.OnArticleClicked(index))
//        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

    }

    private fun render(viewState: ViewState) {
        tvTemp.text = "${viewState.temperature}"
        tvPressure.text = "${viewState.pressure}"
        tvHumidity.text = "${viewState.humidity}"
        tvSpeed.text = "${viewState.speed}"
        tvDeg.text = "${viewState.deg}"
    }

}



