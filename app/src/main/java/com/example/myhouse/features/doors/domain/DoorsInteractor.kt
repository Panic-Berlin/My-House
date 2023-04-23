package com.example.myhouse.features.doors.domain

import com.example.myhouse.features.doors.data.DoorsRepo
import com.example.myhouse.utils.safeRequest
import javax.inject.Inject

class DoorsInteractor @Inject constructor(
    private val doorsRepo: DoorsRepo
) {

    suspend fun getDoors() = safeRequest {
        doorsRepo.getDoors()
    }
}