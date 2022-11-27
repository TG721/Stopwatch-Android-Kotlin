package com.tengizmkcorp.stopwatch.ui.element

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.view.View
import androidx.annotation.UiThread
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tengizmkcorp.stopwatch.R
import com.tengizmkcorp.stopwatch.databinding.FragmentStopwatchBinding
import com.tengizmkcorp.stopwatch.task.StopwatchTask
import com.tengizmkcorp.stopwatch.ui.element.adapter.FlagItemAdapter
import com.tengizmkcorp.stopwatch.ui.element.common.BaseFragment
import com.tengizmkcorp.stopwatch.ui.viewmodel.StopwatchViewModel
import java.util.*
import kotlin.math.roundToInt

class StopwatchFragment :
    BaseFragment<FragmentStopwatchBinding>(FragmentStopwatchBinding::inflate) {
    private val viewModel: StopwatchViewModel by viewModels()
    private lateinit var flagAdapter: FlagItemAdapter
//    private var flagList = mutableListOf<FlagModel>()
     private lateinit var stopwatchTask: StopwatchTask
    private var timerStarted = false
    var time: Double = 0.0
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




    override fun listeners() {
        binding.btPlay.setOnClickListener {
            startStopWatch()
        }
        binding.btStop.setOnClickListener {
            stopTimer("Stop")
            hideButtons()
            binding.stopwatchTV.text = "00:00:00:00"
        }
        binding.btFlag.setOnClickListener {
//            flagList.add(FlagModel(binding.stopwatchTV.text.toString()))
//            flagAdapter.submitList(flagList)
        }
    }

    private fun startStopWatch() {
        if(timerStarted)
        {stopTimer("Pause")
            showResetButton()}
        else
        {
            setupTask(time)
            startTimer()
            hideResetButton()
        }
    }

    private fun hideResetButton() {
        binding.btStop.visibility = View.GONE
    }

    private fun showResetButton() {
        binding.btStop.visibility = View.VISIBLE
    }

    private fun setupTask(currentTime: Double) {
        stopwatchTask = object : StopwatchTask(currentTime)
        {
            override fun run(){
                super.run()
                requireActivity().runOnUiThread {
                    binding.stopwatchTV.text = getTimeStringFromDouble(time)
                }
            }
        }
    }

    private fun stopTimer(pressedButton: String) {
        time = if(pressedButton=="Pause")
            stopwatchTask.time
        else 0.0
        binding.btPlay.setImageResource(R.drawable.ic_baseline_play_arrow_24)
        timerStarted = false
        stopwatchTask.timer.cancel()
        stopwatchTask.cancel()
    }

    private fun startTimer() {
        stopwatchTask.timer.scheduleAtFixedRate(stopwatchTask, 0, 10)
        showFlagButton()
        binding.btPlay.setImageResource(R.drawable.ic_baseline_pause_24)
        timerStarted = true
    }



    private fun showFlagButton() {
        binding.btFlag.visibility = View.VISIBLE
    }

    private fun makeTimeString(hours: Int, minutes: Int, seconds: Int, milliseconds: Int): String {
        return String.format("%02d:%02d:%02d:%02d", hours, minutes, seconds, milliseconds)
    }
    private fun getTimeStringFromDouble(time: Double): String {
        val result = time.roundToInt()
        val hours = result % 8640000 / 360000
        val minutes = result % 8640000 % 360000 / 6000
        val seconds = result % 8640000 % 360000 % 6000 / 100
        val milliseconds = result % 8640000 % 360000 % 6000 % 100
        return makeTimeString(hours, minutes, seconds, milliseconds)

    }
}

//binding.btPlay.setImageResource(R.drawable.ic_baseline_play_arrow_24)