package com.ar4i.testweatherapp.data.network

import com.ar4i.testweatherapp.data.network.response.WeatherForecast
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    companion object {
        private const val URL_PREFIX: String = "data/2.5/"
        private const val FORECAST: String = "forecast/daily"
    }

    @GET(URL_PREFIX + FORECAST)
    fun getForecastByCityId(
        @Query("id") cityId: Long,
        @Query("appid") appId: String
    ): Single<WeatherForecast>
}