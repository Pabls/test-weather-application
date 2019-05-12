package com.ar4i.testweatherapp.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.ar4i.testweatherapp.R
import com.ar4i.testweatherapp.data.network.response.WeatherDay

class DetailsFragment : Fragment() {

    companion object {
        val EXTRA_WEATHER_DAY: String = "EXTRA_WEATHER_DAY"

        @JvmStatic
        fun newInstance(weatherDay: WeatherDay): DetailsFragment {
            var bundle: Bundle = Bundle()
            bundle.putSerializable(EXTRA_WEATHER_DAY, weatherDay)
            var fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    lateinit var toolbar: Toolbar
    lateinit var tvDate: TextView
    lateinit var tvMorningTemp: TextView
    lateinit var tvDayTemp: TextView
    lateinit var tvEveningTemp: TextView
    lateinit var tvNightTemp: TextView
    lateinit var tvHumidity: TextView
    lateinit var tvPressure: TextView
    lateinit var tvSpeed: TextView
    lateinit var tvDeg: TextView
    lateinit var tvDescription: TextView
    lateinit var tvClouds: TextView
    lateinit var tvSnow: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(activity).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        var arguments = arguments?.getSerializable(EXTRA_WEATHER_DAY) as WeatherDay
        tvDate.transitionName = arguments.date.toString()
        setDataToView(arguments)
    }

    private fun initView() {
        tvDate = findViewById(R.id.tv_date)
        tvMorningTemp = findViewById(R.id.tv_morning_temp)
        tvDayTemp = findViewById(R.id.tv_day_temp)
        tvEveningTemp = findViewById(R.id.tv_evening_temp)
        tvNightTemp = findViewById(R.id.tv_night_temp)
        tvHumidity = findViewById(R.id.tv_humidity)
        tvPressure = findViewById(R.id.tv_pressure)
        tvSpeed = findViewById(R.id.tv_speed)
        tvDeg = findViewById(R.id.tv_deg)
        tvDescription = findViewById(R.id.tv_description)
        tvClouds = findViewById(R.id.tv_clouds)
        tvSnow = findViewById(R.id.tv_snow)
        initToolbar()
    }

    private fun initToolbar() {
        toolbar = activity!!.findViewById(R.id.toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_arrow)
        toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun findViewById(id: Int): TextView {
        return activity!!.findViewById(id)
    }

    private fun setDataToView(weatherDay: WeatherDay) {
        tvDate.text = weatherDay.getDate()
        tvMorningTemp.text = weatherDay.temperature.morning.toString()
        tvDayTemp.text = weatherDay.temperature.day.toString()
        tvEveningTemp.text = weatherDay.temperature.evening.toString()
        tvNightTemp.text = weatherDay.temperature.night.toString()
        tvHumidity.text = weatherDay.humidity.toString()
        tvPressure.text = weatherDay.pressure.toString()
        tvSpeed.text = weatherDay.speed.toString()
        tvDeg.text = weatherDay.degrees.toString()
        tvDescription.text = weatherDay.weather[0].description
        tvClouds.text = weatherDay.clouds.toString()
        tvSnow.text =
            weatherDay.snow?.toString() ?: resources.getString(R.string.details_fragment_text_default_snow_value)
        toolbar.title = weatherDay.getDate()
    }
}