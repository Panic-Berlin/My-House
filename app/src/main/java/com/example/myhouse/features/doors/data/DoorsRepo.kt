package com.example.myhouse.features.doors.data

import com.example.myhouse.features.doors.data.api.DoorsApi
import com.example.myhouse.features.doors.data.model.mapper.DoorsMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DoorsRepo @Inject constructor(
    private val api: DoorsApi,
    private val doorsMapper: DoorsMapper
) {

    suspend fun getDoors() = withContext(Dispatchers.IO){
        api.getDoors().let { res -> doorsMapper.map(res) }
    }
}