package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bmicalculator.databinding.ActivityResultBinding
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    val binding by lazy {ActivityResultBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val height = intent.getFloatExtra(MainActivity.HEIGHT, 0f)
        val weight = intent.getFloatExtra(MainActivity.WEIGHT, 0f)

        Toast.makeText(this, "키 : ${height}, 몸무게 : ${weight}", Toast.LENGTH_SHORT).show()

        // 비만도 계산
        val bmi = weight / (height / 100.0f).pow(2.0f)

        // 결과표시
        binding.txtResult.text = when {
            bmi >= 35 -> "고도비만"
            bmi >= 30 -> "2단계 비만"
            bmi >= 25 -> "1단계 비만"
            bmi >= 23 -> "과체중"
            bmi >= 18.5 -> "정상"
            else -> "저체중"
        }

        when {
            bmi >= 23 -> binding.imageView.setImageResource(R.drawable.bad)
            bmi >= 18.5 -> binding.imageView.setImageResource(R.drawable.good)
            else -> binding.imageView.setImageResource(R.drawable.soso)
        }

        Toast.makeText(this, "BMI : $bmi", Toast.LENGTH_SHORT).show()

        binding.btnReturn.setOnClickListener {
            val i = Intent()

            i.putExtra(MainActivity.RESULT, bmi)
            setResult(RESULT_OK, i)
            finish()
        }
    }
}