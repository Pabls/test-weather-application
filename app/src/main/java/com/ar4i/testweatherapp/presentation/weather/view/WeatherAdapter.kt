package com.ar4i.testweatherapp.presentation.weather.view

import android.view.ViewGroup
import com.ar4i.testweatherapp.data.network.response.WeatherDay
import com.ar4i.testweatherapp.presentation.base.view.BaseAdapter
import android.view.LayoutInflater
import androidx.core.view.ViewCompat
import com.ar4i.testweatherapp.R


class WeatherAdapter : BaseAdapter<WeatherDay, WeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_weather_day, parent, false)
        return WeatherViewHolder(view, getSubject())
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        var weatherDay = getItem(position)
        ViewCompat.setTransitionName(holder.tvDate, weatherDay.date.toString())
    }
}