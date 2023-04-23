package com.example.myhouse.features.doors.data.model.mapper

import com.example.myhouse.features.doors.data.model.DataResponse
import com.example.myhouse.features.doors.domain.model.Door
import javax.inject.Inject

class DoorMapper @Inject constructor() {

    fun map(dataResponse: DataResponse) = Door(
        name = dataResponse.name,
        room = dataResponse.room,
        id = dataResponse.id,
        favorites = dataResponse.favorites,
        snapshot = dataResponse.snapshot
    )
}