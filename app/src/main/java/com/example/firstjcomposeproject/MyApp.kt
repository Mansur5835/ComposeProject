package com.example.firstjcomposeproject

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.firstjcomposeproject.di.ApplicationComponent
import com.example.firstjcomposeproject.di.DaggerApplicationComponent
import com.example.firstjcomposeproject.domein.entity.FeedPost
import com.vk.id.VKID
import dagger.internal.DaggerCollections

class MyApp : Application() {


    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(
            this,
            FeedPost("", "", "", "", "", "", "", listOf(), true),
        )
    }

    override fun onCreate() {
        super.onCreate()
        VKID.init(this)
    }
}


@Composable
fun getApplicationComponent(): ApplicationComponent {
    return (LocalContext.current.applicationContext as MyApp).component

}




