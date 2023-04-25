package com.example.myhouse.features.cameras.data.model.mapper

import com.example.myhouse.features.cameras.data.model.CamerasResponse
import com.example.myhouse.features.cameras.domain.model.Cameras
import javax.inject.Inject

class CamerasMapper @Inject constructor(
    private val dataCamerasMapper: DataCamerasMapper
) {

    fun map(camerasResponse: CamerasResponse) = Cameras(
        data = camerasResponse.data.let {
            dataCamerasMapper.map(it)
        },
        success = camerasResponse.success
    )
}