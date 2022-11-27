package com.tengizmkcorp.stopwatch.task

import java.util.*


open class StopwatchTask(var time: Double = 0.0) : TimerTask() {
    val timer: Timer = Timer()
    override fun run() {
        time++
    }

}