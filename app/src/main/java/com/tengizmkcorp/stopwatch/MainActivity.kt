package com.tengizmkcorp.stopwatch

import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.tengizmkcorp.stopwatch.databinding.ActivityMainBinding
import com.tengizmkcorp.stopwatch.ui.element.adapter.ViewPagerAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tabLayout = binding.tabLayout
        val viewPager2 = binding.viewPager
        val mainViewPagerAdapter = ViewPagerAdapter(this)
        viewPager2.adapter = mainViewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager2) { tab, index ->
            tab.text = when (index) {
                0 -> {
                    "Stopwatch"
                }
                else -> {
                    throw Resources.NotFoundException("Position not found")
                }
            }
        }.attach()
    }

}