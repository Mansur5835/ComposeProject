package com.example.firstjcomposeproject

import android.app.Application
import com.vk.id.VKID

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        VKID.init(this)
    }
}