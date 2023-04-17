package com.example.uidesign_basic

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.uidesign_basic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)
//        var txt = findViewById<TextView>(R.id.txtYanjo).apply {
//            text = "나는 이얀조"
//            textSize = 32.0F
//            setTextColor(Color.parseColor("#FF0000"))
//        }
        binding.txtYanjo.apply {
            text = "나는 이얀조"
            textSize = 32.0F
            setTextColor(Color.parseColor("#FF0003"))        }
    }
}