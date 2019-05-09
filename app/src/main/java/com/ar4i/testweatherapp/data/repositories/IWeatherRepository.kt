package com.ar4i.testweatherapp.data.repositories

import com.ar4i.testweatherapp.data.network.response.DayWeather
import io.reactivex.Single

interface IWeatherRepository {
    fun getForecastByCityId(cityId: Long, appId: String): Single<List<DayWeather>>
}