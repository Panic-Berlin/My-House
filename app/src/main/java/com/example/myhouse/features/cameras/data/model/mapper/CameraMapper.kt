package com.example.myhouse.features.cameras.data.model.mapper

import com.example.myhouse.features.cameras.data.model.CameraResponse
import com.example.myhouse.features.cameras.domain.model.Camera
import javax.inject.Inject

class CameraMapper @Inject constructor() {

    fun map(cameraResponse: CameraResponse) = Camera(
        favorites = cameraResponse.favorites,
        id = cameraResponse.id,
        name = cameraResponse.name,
        rec = cameraResponse.rec,
        room = cameraResponse.room,
        snapshot = cameraResponse.snapshot
    )
}