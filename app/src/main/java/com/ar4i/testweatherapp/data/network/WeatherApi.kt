package com.ar4i.testweatherapp.data.network

import com.ar4i.testweatherapp.data.network.response.WeatherForecast
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    companion object {
        private const val URL_PREFIX: String = "data/2.5/"
        private const val URL_FORECAST: String = "forecast/daily"

        private const val QUERY_ID: String = "id"
        private const val QUERY_APPID: String = "appid"
    }

    @GET(URL_PREFIX + URL_FORECAST)
    fun getForecastByCityId(
        @Query(QUERY_ID) cityId: Long,
        @Query(QUERY_APPID) appId: String
    ): Single<WeatherForecast>
}