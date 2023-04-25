package com.example.myhouse.features.cameras.data.api

import com.example.myhouse.features.cameras.data.model.CamerasResponse
import retrofit2.http.GET

interface CamerasApi {

    @GET("cameras")
    suspend fun getCameras(): CamerasResponse
}