package com.example.myhouse.features.doors.data.model.mapper

import com.example.myhouse.features.doors.data.model.DoorsResponse
import com.example.myhouse.features.doors.domain.model.Doors
import javax.inject.Inject

class DoorsMapper @Inject constructor(
    private val dataMapper: DoorMapper
) {

    fun map(doorsResponse: DoorsResponse) = Doors(
        success = doorsResponse.success,
        data =  doorsResponse.data.map {
            dataMapper.map(it)
        }
    )
}