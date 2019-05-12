package com.ar4i.testweatherapp.app.di.modules

import android.content.Context
import com.ar4i.testweatherapp.data.network.WeatherApi
import com.ar4i.testweatherapp.data.repositories.WeatherRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoriesModule {

    @Provides
    fun provideWeatherRepository(weatherApi: WeatherApi, context: Context): WeatherRepository {
        return WeatherRepository(weatherApi, context)
    }
}