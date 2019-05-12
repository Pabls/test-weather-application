package com.ar4i.testweatherapp.app.di.components

import com.PresentationModule
import com.ar4i.testweatherapp.app.App
import com.ar4i.testweatherapp.app.di.modules.AppModule
import com.ar4i.testweatherapp.app.di.modules.NetworkModule
import com.ar4i.testweatherapp.presentation.weather.view.WeatherFragment
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = arrayOf(
        AppModule::class,
        NetworkModule::class,
        PresentationModule::class
    )
)
@Singleton
interface ApplicationComponent {
    fun inject(weatherFragment: WeatherFragment)
}