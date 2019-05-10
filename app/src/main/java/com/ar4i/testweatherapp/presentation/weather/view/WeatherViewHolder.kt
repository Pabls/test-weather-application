package com.ar4i.testweatherapp.presentation.weather.view

import android.view.View
import android.widget.TextView
import com.ar4i.testweatherapp.R
import com.ar4i.testweatherapp.data.network.response.WeatherDay
import com.ar4i.testweatherapp.presentation.base.view.BaseViewHolder
import io.reactivex.subjects.PublishSubject

class WeatherViewHolder : BaseViewHolder<WeatherDay> {

    constructor(item: View, itemViewClickSubject: PublishSubject<Int>) : super(item, itemViewClickSubject) {
        tvDate = item.findViewById(R.id.tv_date)
        tvDay = item.findViewById(R.id.tv_day)
        tvMin = item.findViewById(R.id.tv_min)
        tvMax = item.findViewById(R.id.tv_max)
        tvWeather = item.findViewById(R.id.tv_weather)
    }

    var tvDate: TextView
    var tvDay: TextView
    var tvMin: TextView
    var tvMax: TextView
    var tvWeather: TextView

    override fun bind(item: WeatherDay) {
        tvDate.setText(item.getDate())
        tvDay.setText(item.temperature.day.toString())
        tvMin.setText(item.temperature.min.toString())
        tvMax.setText(item.temperature.max.toString())
        tvWeather.setText(item.weather.get(0).main)
    }
}