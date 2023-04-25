package com.example.myhouse.features.cameras.domain

import com.example.myhouse.features.cameras.data.CamerasRepo
import com.example.myhouse.utils.safeRequest
import javax.inject.Inject

class CamerasInteractor @Inject constructor(
    private val camerasRepo: CamerasRepo
) {

    suspend fun getCameras() = safeRequest {
        camerasRepo.getCameras()
    }
}