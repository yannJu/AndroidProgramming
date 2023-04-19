package com.example.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    // 상수 정의
    companion object {
        val REQUEST = 0
        val ID = "ID"
        val PASSWD = "PASSWD"
        val RESULT = "RESULT"
    }
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)
        setUpUI()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != REQUEST) return

        data?.getStringExtra(RESULT).let {
            binding.txtResult.text = it
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun setUpUI() {
        binding.btnSMS.setOnClickListener {
            val uri = Uri.parse("smsto:01011112222")
            val intent = Intent(Intent.ACTION_SENDTO, uri)

            intent.putExtra("sms_body", "문자보내기. . .?")
            startActivity(intent)
        }

        binding.btnInternet.setOnClickListener {
            val uri = Uri.parse("http://vintageappmaker.tumblr.com/")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            startActivity(intent)
        }

        binding.btnMap.setOnClickListener {
            val uri = Uri.parse("geo: 37.5310091, 127.0261659")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.btnMarket.setOnClickListener {
            val uri = Uri.parse("market://details?id=com.psw.moringcall")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        // 다른 Activity로 이동
        binding.btnActivity.setOnClickListener {
            val i = Intent(this, MainActivity2::class.java)
            startActivity(i)
        }

        // 다른 Activity로 이동하고 값 반환 받기
        binding.btnLogin.setOnClickListener {
            binding.txtResult.text = ""

            val i = Intent(this, MainActivity3::class.java)
            i.putExtra(ID, binding.txtName.text.toString())
            i.putExtra(PASSWD, binding.txtPwd.text.toString())

            startActivityForResult(i, REQUEST)
        }
    }
}