package com.example.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.timer.databinding.ActivityMainBinding
import java.util.Timer
import java.util.TimerTask
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    var time = 0
    var timerTask: Timer? = null
    var isRunning = false
    var lap = 1

    var isBackBtnClick = 0
    var backTime = 0
    var backTimerTask: Timer? = null

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAction.setOnClickListener {
            isRunning = !isRunning

            if (isRunning) start()
            else pause()
        }

        binding.btnLaptime.setOnClickListener {
            recordLapTime()
        }

        binding.btnRefresh.setOnClickListener {
            reset()
        }
    }

    fun start() {
        binding.btnAction.setImageResource(R.drawable.pause)
        timerTask = timer(period=10) {
            time++
            val sec = time / 100
            val milli = time % 100

            runOnUiThread {
                binding.txtSec.text = "$sec"
                binding.txtMill.text = "$milli"
            }
        }
    }

    fun pause() {
        binding.btnAction.setImageResource(R.drawable.play)
        timerTask?.cancel()
    }

    fun recordLapTime() {
        val lapTime = this.time
        val sec = lapTime / 100
        val milli = lapTime % 100

        val textView = TextView(this)
        textView.text = "Lap $lap : $sec.$milli"
        binding.layoutLap.addView(textView, 0)

        lap++
    }

    fun reset() {
        pause()

        time = 0
        isRunning = false
        lap = 1

        binding.txtSec.text = "0"
        binding.txtMill.text = "00"

        binding.layoutLap.removeAllViews()
    }

    override fun onBackPressed() {
        if (isBackBtnClick == 0) {
            isBackBtnClick = 1

            Toast.makeText(this, "한번 더 누르면 프로그램이 종료됩니다 . .", Toast.LENGTH_SHORT).show()

//            backTimerTask = timer(period=10) {
//                backTime++
//
//                if (backTime > 300) {
//                    isBackBtnClick = 0
//                    backTime = 0
//                    return@timer
//                }
//            }
            backTimerTask = timer(period = 3000) {
                if (isBackBtnClick == 1) {
                    backTimerTask?.cancel()
                    isBackBtnClick = 0
                    return@timer
                }
            }
        }
        else {
//            if (backTime <= 300) {
//                super.onBackPressed()
//            }
            backTimerTask?.cancel()
            super.onBackPressed()
        }
    }
}