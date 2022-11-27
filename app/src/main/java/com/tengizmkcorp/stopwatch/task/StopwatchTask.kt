package com.tengizmkcorp.stopwatch.task

import android.widget.TextView
import java.util.*
import kotlin.math.roundToInt


open class StopwatchTask():  TimerTask(){
    var time = 0.0
    val timer: Timer = Timer()
    override fun run() {
        time++
    }

}