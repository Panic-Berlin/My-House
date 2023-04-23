package com.example.myhouse.features.doors.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DoorsResponse(
    val data: List<DataResponse>,
    val success: Boolean
)

@JsonClass(generateAdapter = true)
data class DataResponse(
    val favorites: Boolean,
    val id: Int,
    val name: String,
    val room: String,
    val snapshot: String
)