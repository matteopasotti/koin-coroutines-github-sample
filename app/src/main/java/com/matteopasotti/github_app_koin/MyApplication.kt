package com.matteopasotti.github_app_koin

import android.app.Application
import com.matteopasotti.github_app_koin.di.mainModule
import com.matteopasotti.github_app_koin.di.netModule
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this , listOf(mainModule, netModule))
    }
}