package com.example.myhouse.features.doors.di

import com.example.myhouse.features.doors.data.api.DoorsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class DoorsFeatureModule {

    @Provides
    fun provideDoorsApi(retrofit: Retrofit) = retrofit.create(
        DoorsApi::class.java
    )
}