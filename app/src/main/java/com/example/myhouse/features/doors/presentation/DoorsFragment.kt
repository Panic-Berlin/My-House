package com.example.myhouse.features.doors.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myhouse.R
import com.example.myhouse.databinding.FragmentDoorsBinding
import com.example.myhouse.utils.ViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoorsFragment : Fragment(R.layout.fragment_doors) {

    private val viewBinding: FragmentDoorsBinding by viewBinding(FragmentDoorsBinding::bind)
    private val viewModel: DoorsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observe()
    }

    private fun observe() {
        viewModel.doors.observe(viewLifecycleOwner){
            if (it is ViewState.Show){
                Log.d("DoorsFragment", "observe: ${it.data}")
            }
        }
    }

    private fun initViews() {

    }
}