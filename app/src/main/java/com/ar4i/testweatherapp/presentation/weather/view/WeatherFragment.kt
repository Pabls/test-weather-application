package com.ar4i.testweatherapp.presentation.weather.view

import android.os.Bundle
import android.view.View
import com.ar4i.testweatherapp.R
import com.ar4i.testweatherapp.presentation.base.view.BaseFragment
import com.ar4i.testweatherapp.presentation.weather.presenter.WeatherPresenter
import javax.inject.Inject

class WeatherFragment : BaseFragment(), IWeatherView {

    companion object {
        @JvmStatic
        fun newInstance():WeatherFragment {
            return WeatherFragment()
        }
    }

    @Inject
    lateinit var presenter: WeatherPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
    }

    override fun onDetach() {
        super.onDetach()
        presenter.detachView()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_weather
    }

    override fun inject() {
        getComponent().inject(this)
    }
}
