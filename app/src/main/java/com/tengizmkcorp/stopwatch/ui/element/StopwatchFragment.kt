package com.tengizmkcorp.stopwatch.ui.element

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tengizmkcorp.stopwatch.R
import com.tengizmkcorp.stopwatch.databinding.FragmentStopwatchBinding
import com.tengizmkcorp.stopwatch.ui.element.adapter.FlagItemAdapter
import com.tengizmkcorp.stopwatch.ui.element.common.BaseFragment
import com.tengizmkcorp.stopwatch.ui.viewmodel.StopwatchViewModel
import kotlin.math.roundToInt

class StopwatchFragment :
    BaseFragment<FragmentStopwatchBinding>(FragmentStopwatchBinding::inflate) {
    private val viewModel: StopwatchViewModel by viewModels()
    private lateinit var flagAdapter: FlagItemAdapter
//    private var flagList = mutableListOf<FlagModel>()
    private var timerStarted = false
    private lateinit var serviceIntent: Intent
    override fun setup() {
        hideButtons()
//        setupFlagsRecycler()
    }

//    private fun setupFlagsRecycler() {
//        flagAdapter = FlagItemAdapter()
//        val recycler = binding.flagRV
//        recycler.adapter = flagAdapter
//        recycler.layoutManager = LinearLayoutManager(requireContext())
//    }

    private fun hideButtons() {
        binding.btStop.visibility = View.GONE
        binding.btFlag.visibility = View.GONE
    }

    private fun getTimeStringFromDouble(time: Double): String {
        val result = time.roundToInt()
        val hours = result % 8640000 / 360000
        val minutes = result % 8640000 % 360000 / 6000
        val seconds = result % 8640000 % 360000 % 6000 / 100
        val milliseconds = result % 8640000 % 360000 % 6000 % 100
        return makeTimeString(hours, minutes, seconds, milliseconds)

    }

    private fun makeTimeString(hours: Int, minutes: Int, seconds: Int, milliseconds: Int): String {
        return String.format("%02d:%02d:%02d:%02d", hours, minutes, seconds, milliseconds)
    }

    override fun listeners() {
        binding.btPlay.setOnClickListener {

        }
        binding.btStop.setOnClickListener {

        }
        binding.btFlag.setOnClickListener {
//            flagList.add(FlagModel(binding.stopwatchTV.text.toString()))
//            flagAdapter.submitList(flagList)
        }
    }


    private fun showButtons() {
        binding.btStop.visibility = View.VISIBLE
        binding.btFlag.visibility = View.VISIBLE
    }


}

//binding.btPlay.setImageResource(R.drawable.ic_baseline_play_arrow_24)