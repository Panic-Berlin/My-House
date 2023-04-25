package com.example.myhouse.features.cameras.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myhouse.R
import com.example.myhouse.databinding.FragmentCamerasBinding
import com.example.myhouse.features.cameras.presentation.adapter.CamerasAdapter
import com.example.myhouse.features.doors.presentation.adapter.DoorsAdapter
import com.example.myhouse.utils.ViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CamerasFragment : Fragment(R.layout.fragment_cameras) {

    private val viewBinding: FragmentCamerasBinding by viewBinding(FragmentCamerasBinding::bind)
    private val viewModel: CamerasViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
    }

    private fun observe() {
        viewBinding.rvCameras.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        viewModel.cameras.observe(viewLifecycleOwner) {
            when (it) {
                is ViewState.Show -> {
                    viewBinding.rvCameras.adapter = CamerasAdapter(it.data.data.cameras)
                    viewBinding.pbCameras.isVisible = false
                }
                is ViewState.Error -> {
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(requireContext(), "else", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}