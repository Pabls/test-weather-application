package com.ar4i.testweatherapp.presentation.weather.presenter

import com.ar4i.testweatherapp.BuildConfig
import com.ar4i.testweatherapp.data.repositories.IWeatherRepository
import com.ar4i.testweatherapp.presentation.base.presenter.BasePresenter
import com.ar4i.testweatherapp.presentation.weather.view.IWeatherView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WeatherPresenter : BasePresenter<IWeatherView> {

    @Inject
    constructor(weatherRepository: IWeatherRepository) {
        this.weatherRepository = weatherRepository
    }

    var weatherRepository: IWeatherRepository

    override fun attachView(v: IWeatherView) {
        super.attachView(v)
        getForecast()
    }

    private fun getForecast() {
        track(
            weatherRepository.getForecastByCityId(524901, BuildConfig.APP_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ res ->
                    res.size
                }, { error ->
                    error.message?.let { getView()?.showMessage(it) }
                })
        )
    }
}