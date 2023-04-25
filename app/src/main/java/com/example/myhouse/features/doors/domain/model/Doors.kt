package com.example.myhouse.features.doors.domain.model

data class Doors(
    val success: Boolean,
    val data: List<Door>
)

data class Door(
    val favorites: Boolean,
    val id: Int,
    val name: String,
    val room: String?,
    val snapshot: String?
)