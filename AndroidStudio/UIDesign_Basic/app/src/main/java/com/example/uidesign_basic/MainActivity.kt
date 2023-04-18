package com.example.uidesign_basic

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.TextView
import com.example.uidesign_basic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var nCount : Int = 0 // class 의 멤버 변수는 꼭! 초기화 되어야 한다.
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

        // Java Style
//        binding.btn2.setOnClickListener(
//            View.OnClickListener() {
//                text = "클릭된 2얀조 . . ㅋ ㅣ킥"
//                textSize = 32.0F
//                setTextColor(Color.parseColor("#FF0053"))
//            }
//        )
        binding.btn2.setOnClickListener {
            binding.btn2.apply {
                text = "클릭된 2얀조 . . ㅋ ㅣ킥"
                textSize = 32.0F
                setTextColor(Color.parseColor("#FF0053"))
            }
        }

        // ================== Text View
        binding.textNormal.setOnClickListener {
            binding.textNormal.apply {
                setBackgroundColor(Color.GREEN)
                text = "클릭된 Normal Text View ! '-' >> ${++nCount} 번 클릭 됨 🍪"
                setTextColor(Color.WHITE)
                setTextSize(28.0F)
            }
        }

        binding.textHtml.setOnClickListener {
            val htmlText = it as TextView
            htmlText.text = Html.fromHtml(
                "<h1>H i . .</hi>HTML<p style = \"color : red;\">RED</p>"
            )
        }
    }
}