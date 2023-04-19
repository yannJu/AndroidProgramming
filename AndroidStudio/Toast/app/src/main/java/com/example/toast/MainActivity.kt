package com.example.toast

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import com.example.toast.databinding.ActivityMainBinding
import com.example.toast.databinding.CustomToastBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnNormal.setOnClickListener {
            Toast.makeText(application, "Toast 클릭 ^ ㅇ ^ /", Toast.LENGTH_LONG).show()
        }

        binding.btnCustom.setOnClickListener {
            showCustom("Yanjo . . ")
        }
    }

    private fun showCustom(s: String) {
        //val layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = layoutInflater.inflate(R.layout.custom_toast, null)
        // val layout = CustomToastBinding.inflate(layoutInflater).root 위와 동일

        val txtMessage = layout.findViewById<TextView>(R.id.txtMessage)
        txtMessage.text = s

        val toast = Toast(applicationContext)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()
    }
}