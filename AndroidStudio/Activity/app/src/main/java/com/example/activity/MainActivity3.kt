package com.example.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activity.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    val binding by lazy {ActivityMain3Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}