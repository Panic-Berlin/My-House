package com.example.myhouse.features.cameras.data

import com.example.myhouse.features.cameras.data.api.CamerasApi
import com.example.myhouse.features.cameras.data.model.mapper.CamerasMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CamerasRepo @Inject constructor(
    private val api: CamerasApi,
    private val camerasMapper: CamerasMapper
){

    suspend fun getCameras() = withContext(Dispatchers.IO){
        api.getCameras().let { res -> camerasMapper.map(res) }
    }
}