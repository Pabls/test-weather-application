package com.ar4i.testweatherapp.app

import android.app.Application
import com.ar4i.testweatherapp.app.di.components.ApplicationComponent
import com.ar4i.testweatherapp.app.di.components.DaggerApplicationComponent
import com.ar4i.testweatherapp.app.di.modules.AppModule

class App : Application() {

    companion object {
        lateinit var appComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}