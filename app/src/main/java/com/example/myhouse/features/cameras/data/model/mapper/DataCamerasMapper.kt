package com.example.myhouse.features.cameras.data.model.mapper

import com.example.myhouse.features.cameras.data.model.DataCamerasResponse
import com.example.myhouse.features.cameras.domain.model.DataCameras
import javax.inject.Inject

class DataCamerasMapper @Inject constructor(
    private val cameraMapper: CameraMapper
) {

    fun map(dataCameras: DataCamerasResponse) = DataCameras(
        cameras = dataCameras.cameras.map {
            cameraMapper.map(it)
        },
        room = dataCameras.room
    )
}