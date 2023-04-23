package com.example.myhouse.features.cameras.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myhouse.R
import com.example.myhouse.databinding.FragmentCamerasBinding

class CamerasFragment : Fragment(R.layout.fragment_cameras) {

    private val viewBinding: FragmentCamerasBinding by viewBinding(FragmentCamerasBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observe()
    }

    private fun observe() {

    }

    private fun initViews() {

    }
}