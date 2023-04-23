package com.example.myhouse.features.doors.data.api

import com.example.myhouse.features.doors.data.model.DoorsResponse
import retrofit2.http.GET

interface DoorsApi {

    @GET("doors")
    suspend fun getDoors(): DoorsResponse
}