package com.ar4i.testweatherapp.app.di.modules

import com.ar4i.testweatherapp.data.network.WeatherApi
import com.ar4i.testweatherapp.data.repositories.WeatherRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoriesModule {

    @Provides
    fun provideWeatherRepository(weatherApi: WeatherApi): WeatherRepository {
        return WeatherRepository(weatherApi)
    }
}