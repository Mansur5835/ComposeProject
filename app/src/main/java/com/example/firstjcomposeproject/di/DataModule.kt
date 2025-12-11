package com.example.firstjcomposeproject.di

import com.example.firstjcomposeproject.data.mapper.NewsFeedMapper
import com.example.firstjcomposeproject.data.nerwork.ApiFactory
import com.example.firstjcomposeproject.data.nerwork.ApiService
import com.example.firstjcomposeproject.data.repository.NewsFeedRepositoryImpl
import com.example.firstjcomposeproject.domein.repository.NewsFeedRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(impl: NewsFeedRepositoryImpl): NewsFeedRepository


    companion object {
        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }


}