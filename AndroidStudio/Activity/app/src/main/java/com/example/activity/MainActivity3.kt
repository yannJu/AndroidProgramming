package com.example.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activity.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    val binding by lazy {ActivityMain3Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Activity는 버튼 클릭시 닫혀야 한다.
        binding.btnOk.setOnClickListener {
            var i = Intent()
            i.putExtra(MainActivity.RESULT, binding.txtReturn.text.toString())
            setResult(Activity.RESULT_OK, i)
            finish()
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()

        var i = intent?:return

        val sID = i.getStringExtra(MainActivity.ID)
        val sPassWd = i.getStringExtra(MainActivity.PASSWD)

        binding.txtReturn.text = "아이디 : ${sID}\n패스워드 : ${sPassWd}"
//        i.putExtra(MainActivity.RESULT, binding.txtReturn.text.toString())
//
//        setResult(MainActivity.REQUEST, i)
    }
}