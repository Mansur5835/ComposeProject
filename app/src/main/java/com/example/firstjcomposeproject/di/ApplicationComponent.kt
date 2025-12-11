package com.example.firstjcomposeproject.di

import android.content.Context
import com.example.firstjcomposeproject.MainActivity
import com.example.firstjcomposeproject.domein.entity.FeedPost
import com.example.firstjcomposeproject.ui.viewmodel.ViewModelFactory
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class,
    ]
)
interface ApplicationComponent {


    fun getViewModelFactory(): ViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance feedPost: FeedPost
        ): ApplicationComponent
    }


}