package com.tengizmkcorp.stopwatch.ui.element.adapter

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tengizmkcorp.stopwatch.ui.element.StopwatchFragment


class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 1
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
             0 -> {return StopwatchFragment()}
            else -> {throw Resources.NotFoundException("Position not found")}
        }
    }

}