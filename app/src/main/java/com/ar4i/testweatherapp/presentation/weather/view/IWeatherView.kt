package com.ar4i.testweatherapp.presentation.weather.view

import com.ar4i.testweatherapp.data.network.response.WeatherDay
import com.ar4i.testweatherapp.presentation.base.view.IBaseView
import io.reactivex.Observable

interface IWeatherView : IBaseView {
    fun showData(days: List<WeatherDay>)
    fun onItemClick(): Observable<Int>
}