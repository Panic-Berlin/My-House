package com.example.myhouse.features.cameras.di

import com.example.myhouse.features.cameras.data.api.CamerasApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class CamerasFeatureModule {

    @Provides
    fun provideCamerasApi(retrofit: Retrofit) = retrofit.create(
        CamerasApi::class.java
    )
}