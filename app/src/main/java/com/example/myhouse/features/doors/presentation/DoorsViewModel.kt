package com.example.myhouse.features.doors.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhouse.features.doors.domain.DoorsInteractor
import com.example.myhouse.features.doors.domain.model.Doors
import com.example.myhouse.utils.ViewState
import com.example.myhouse.utils.asLiveData
import com.example.myhouse.utils.asViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DoorsViewModel @Inject constructor(
    private val doorsInteractor: DoorsInteractor
): ViewModel() {

    private val _doors = MutableLiveData<ViewState<Doors>>()
    val doors get() = _doors.asLiveData()

    init {
        getDoors()
    }

    private fun getDoors(){
        viewModelScope.launch {
            _doors.value = doorsInteractor.getDoors().asViewState()
            Log.d("DoorsViewModel", "getDoors: ${_doors.value}")
        }
    }
}