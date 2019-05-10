package com.ar4i.testweatherapp.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherDay(
    @SerializedName("dt") @Expose val date: Long,
    @SerializedName("pressure") @Expose val pressure: Double,
    @SerializedName("humidity") @Expose val humidity: Byte,
    @SerializedName("speed") @Expose val speed: Double,
    @SerializedName("deg") @Expose val degrees: Int,
    @SerializedName("clouds") @Expose val clouds: Byte,
    @SerializedName("temp") @Expose val temperature: Temperature,
    @SerializedName("weather") @Expose val weather: MutableList<Weather>,
    @SerializedName("snow") @Expose val snow: Double?
)