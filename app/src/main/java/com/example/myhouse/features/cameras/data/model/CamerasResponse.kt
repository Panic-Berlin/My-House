package com.example.myhouse.features.cameras.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CamerasResponse(
    val data: DataCamerasResponse,
    val success: Boolean
)

@JsonClass(generateAdapter = true)
data class DataCamerasResponse(
    val cameras: List<CameraResponse>,
    val room: List<String>
)

@JsonClass(generateAdapter = true)
data class CameraResponse(
    val favorites: Boolean,
    val id: Int,
    val name: String,
    val rec: Boolean,
    val room: String?,
    val snapshot: String
)