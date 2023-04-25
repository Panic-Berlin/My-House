package com.example.myhouse.features.doors.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myhouse.R
import com.example.myhouse.databinding.FragmentDoorsBinding
import com.example.myhouse.features.doors.presentation.adapter.DoorsAdapter
import com.example.myhouse.utils.ViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoorsFragment : Fragment(R.layout.fragment_doors) {

    private val viewBinding: FragmentDoorsBinding by viewBinding(FragmentDoorsBinding::bind)
    private val viewModel: DoorsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
    }

    private fun observe() {
        viewBinding.rvDoors.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        viewModel.doors.observe(viewLifecycleOwner) {
            when (it) {
                is ViewState.Show -> {
                    viewBinding.rvDoors.adapter = DoorsAdapter(it.data.data)
                    viewBinding.pbDoors.isVisible = false
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