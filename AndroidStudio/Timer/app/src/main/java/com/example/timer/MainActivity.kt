package com.example.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.timer.databinding.ActivityMainBinding
import java.util.Timer
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    var time = 0
    var timerTask: Timer? = null
    var isRunning = false
    var lap = 1

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
}