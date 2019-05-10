package com.ar4i.testweatherapp.data.repositories

import com.ar4i.testweatherapp.data.network.WeatherApi
import com.ar4i.testweatherapp.data.network.response.WeatherDay
import io.reactivex.Single
import javax.inject.Inject

class WeatherRepository : IWeatherRepository {

    @Inject
    constructor(weatherApi: WeatherApi) {
        this.weatherApi = weatherApi
    }

    var weatherApi: WeatherApi

    override fun getForecastByCityId(cityId: Long, appId: String): Single<List<WeatherDay>> {
        return weatherApi.getForecastByCityId(cityId, appId)
            .map { weatherForecast ->
                weatherForecast.days
            }
    }
}