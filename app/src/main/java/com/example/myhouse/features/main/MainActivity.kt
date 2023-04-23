package com.example.myhouse.features.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myhouse.R
import com.example.myhouse.databinding.ActivityMainBinding
import com.example.myhouse.features.cameras.presentation.CamerasFragment
import com.example.myhouse.features.doors.presentation.DoorsFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewBinding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)
    private val fragments = listOf(
        CamerasFragment(),
        DoorsFragment()
    )
    private val fragmentTitles = listOf(
        R.string.cameras,
        R.string.doors,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val viewPagerAdapter = ViewPagerAdapter(this, fragments)
        viewBinding.vpPage.adapter = viewPagerAdapter
        TabLayoutMediator(viewBinding.tlNavigation, viewBinding.vpPage){
            tab, position -> tab.text = getText(fragmentTitles[position])
        }.attach()
    }
}