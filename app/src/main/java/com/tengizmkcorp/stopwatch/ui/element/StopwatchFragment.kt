package com.tengizmkcorp.stopwatch.ui.element

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tengizmkcorp.stopwatch.R
import com.tengizmkcorp.stopwatch.databinding.FragmentStopwatchBinding
import com.tengizmkcorp.stopwatch.ui.element.common.BaseFragment
import com.tengizmkcorp.stopwatch.ui.viewmodel.StopwatchViewModel
import androidx.fragment.app.viewModels

class StopwatchFragment : BaseFragment<FragmentStopwatchBinding>(FragmentStopwatchBinding::inflate) {
    private val viewModel: StopwatchViewModel by viewModels()
    override fun setup() {

    }

}