package com

import com.ar4i.testweatherapp.data.repositories.WeatherRepository
import com.ar4i.testweatherapp.presentation.weather.presenter.WeatherPresenter
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {
    @Provides
    fun provideWeatherPresenter(weatherRepository: WeatherRepository): WeatherPresenter {
        return WeatherPresenter(weatherRepository)
    }
}