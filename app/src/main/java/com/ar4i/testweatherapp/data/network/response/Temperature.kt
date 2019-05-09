package com.ar4i.testweatherapp.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Temperature(
    @SerializedName("day") @Expose val day: Double,
    @SerializedName("min") @Expose val min: Double,
    @SerializedName("max") @Expose val max: Double,
    @SerializedName("night") @Expose val night: Double,
    @SerializedName("eve") @Expose val evening: Double,
    @SerializedName("morn") @Expose val morning: Double
)