package com.ar4i.testweatherapp.presentation.weather.presenter

import com.ar4i.testweatherapp.data.repositories.IWeatherRepository
import com.ar4i.testweatherapp.presentation.base.presenter.BasePresenter
import com.ar4i.testweatherapp.presentation.weather.view.IWeatherView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WeatherPresenter : BasePresenter<IWeatherView> {

    @Inject
    constructor(weatherRepository: IWeatherRepository, cityId: Long, appId: String) {
        this.weatherRepository = weatherRepository
        this.cityId = cityId
        this.appId = appId
    }

    var weatherRepository: IWeatherRepository
    var cityId: Long
    var appId: String

    override fun attachView(v: IWeatherView) {
        super.attachView(v)
        getForecast()

        track(getView()!!.onItemClick()
            .subscribe { index ->
                getView()?.showMessage(index.toString())
            }
        )
    }

    private fun getForecast() {
        track(
            weatherRepository.getForecastByCityId(cityId, appId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ days ->
                    getView()?.showData(days)
                }, { error ->
                    error.message?.let { getView()?.showMessage(it) }
                })
        )
    }
}