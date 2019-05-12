package com.ar4i.testweatherapp.data.repositories

import android.content.Context
import com.ar4i.testweatherapp.R
import com.ar4i.testweatherapp.data.network.ApiUtils
import com.ar4i.testweatherapp.data.network.WeatherApi
import com.ar4i.testweatherapp.data.network.response.WeatherDay
import io.reactivex.Single
import javax.inject.Inject

class WeatherRepository : IWeatherRepository {

    @Inject
    constructor(weatherApi: WeatherApi, context: Context) {
        this.weatherApi = weatherApi
        this.context = context
    }

    var weatherApi: WeatherApi
    var context: Context

    override fun getForecastByCityId(cityId: Long, appId: String): Single<List<WeatherDay>> {
        return weatherApi.getForecastByCityId(cityId, appId)
            .onErrorResumeNext { e ->
                if (ApiUtils.NETWORK_EXCEPTIONS.contains(e::class.java))
                    Single.error(Exception(context.getString(R.string.check_connection)))
                else
                    Single.error(e)
            }
            .map { weatherForecast ->
                weatherForecast.days
            }
    }
}