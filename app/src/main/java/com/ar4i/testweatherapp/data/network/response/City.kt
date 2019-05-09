package com.ar4i.testweatherapp.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("geoname_id") @Expose val id: Long,
    @SerializedName("name") @Expose val name: String,
    @SerializedName("lat") @Expose val latitude: Double,
    @SerializedName("lon") @Expose val longitude: Double,
    @SerializedName("country") @Expose val country: String,
    @SerializedName("iso2") @Expose val iso2: String,
    @SerializedName("type") @Expose val type: String,
    @SerializedName("population") @Expose val population: Long
)