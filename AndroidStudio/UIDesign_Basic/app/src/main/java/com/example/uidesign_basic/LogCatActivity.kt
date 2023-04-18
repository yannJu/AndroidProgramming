package com.example.uidesign_basic

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.uidesign_basic.databinding.LogcatBinding
import java.lang.Exception

class LogCatActivity : AppCompatActivity() {
    var nCount :Int = 0
    var maxCount :Int = 10
    val binding by lazy {LogcatBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogCat.setOnClickListener {
            Log.d(javaClass.name, "${++nCount} Clicked . . ")
            try {
                val nResult = maxCount / (maxCount - nCount)
                Log.d("My Log", "nMaxCount / (nMaxCount - nCount) is ${nResult} !")
            }catch (e : Exception) {
                Log.d("My Err Log", "${nCount} : ${e.toString()}")
            }
        }
    }
}