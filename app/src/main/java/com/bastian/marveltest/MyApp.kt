package com.bastian.marveltest

import android.app.Application
import com.bastian.marveltest.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(networkModule)
        }
    }
}