package com.ar4i.testweatherapp.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.ar4i.testweatherapp.R
import com.ar4i.testweatherapp.presentation.weather.view.WeatherFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var fm = supportFragmentManager
        fm.beginTransaction()
            .add(R.id.fl_container, WeatherFragment.newInstance())
            .commit()
    }
}
