package com.example.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    var nLineNumber = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("AllTest", String.format("\n%d : onCreate", nLineNumber++))
    }

    // onStart override (Activity가 최초 실행되었을 때)
    override fun onStart() {
        super.onStart()
        Log.d("AllTest", String.format("\n%d : onStart", nLineNumber++))
    }

    // onResume override (현재 Activity가 맨 앞으로 왔을 때)
    override fun onResume() {
        super.onResume()
        Log.d("AllTest", String.format("\n%d : onResume", nLineNumber++))
    }

    // onStop override (다른 Activity가 맨 앞으로 왔을 때)
    override fun onStop() {
        super.onStop()
        Log.d("AllTest", String.format("\n%d : onStop", nLineNumber++))
    }

    // onDestroy override (Activity가 완전히 종료되었을 때)
    override fun onDestroy() {
        super.onDestroy()
        Log.d("AllTest", String.format("\n%d : onDestroy", nLineNumber++))
    }
}