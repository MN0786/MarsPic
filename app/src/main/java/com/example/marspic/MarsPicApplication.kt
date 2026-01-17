package com.example.marspic

import android.app.Application
import com.example.marspic.data.AppContainer
import com.example.marspic.data.DefaultAppContainer

class MarsPicApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {

        super.onCreate()
        container = DefaultAppContainer()
    }
}