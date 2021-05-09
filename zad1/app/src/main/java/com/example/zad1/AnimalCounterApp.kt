package com.example.zad1

import android.app.Application
import com.example.zad1.di.appModules
import com.example.zad1.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class AnimalCounterApp : Application() {

    companion object{
        lateinit var application: AnimalCounterApp
    }

    override fun onCreate() {
        super.onCreate()
        application = this

        startKoin {
            androidContext(this@AnimalCounterApp)
            modules(appModules, viewModelModule)
        }
    }
}