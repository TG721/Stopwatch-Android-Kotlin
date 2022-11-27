package com.tengizmkcorp.stopwatch.task

import android.widget.TextView
import java.util.*
import kotlin.math.roundToInt


open class StopwatchTask( var time: Double = 0.0):  TimerTask(){
    val timer: Timer = Timer()
    override fun run() {
        time++
    }

}