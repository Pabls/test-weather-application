package com.ar4i.testweatherapp.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherForecast(
    @SerializedName("cod") @Expose val cod: Int,
    @SerializedName("message") @Expose val message: String,
    @SerializedName("city") @Expose val city: City,
    @SerializedName("cnt") @Expose val cnt: Int,
    @SerializedName("list") @Expose val days: MutableList<WeatherDay>
)