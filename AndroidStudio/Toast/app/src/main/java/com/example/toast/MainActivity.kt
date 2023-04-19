package com.example.toast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.toast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.btnNormal.setOnClickListener {
            Toast.makeText(application, "Toast 클릭 ^ ㅇ ^ /", Toast.LENGTH_LONG).show()
        }
    }
}