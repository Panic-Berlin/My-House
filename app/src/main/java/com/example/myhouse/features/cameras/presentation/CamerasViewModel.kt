package com.example.myhouse.features.cameras.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhouse.features.cameras.domain.CamerasInteractor
import com.example.myhouse.features.cameras.domain.model.Cameras
import com.example.myhouse.utils.ViewState
import com.example.myhouse.utils.asLiveData
import com.example.myhouse.utils.asViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CamerasViewModel @Inject constructor(
    private val camerasInteractor: CamerasInteractor
): ViewModel(){

    private val _cameras = MutableLiveData<ViewState<Cameras>>()
    val cameras get() = _cameras.asLiveData()

    init {
        getCameras()
    }

    private fun getCameras(){
        viewModelScope.launch {
            _cameras.value = camerasInteractor.getCameras().asViewState()
            Log.d("CamerasViewModel", "getCameras: ${_cameras.value}")
        }
    }
}