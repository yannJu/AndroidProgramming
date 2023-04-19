package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    companion object {
        val HEIGHT = "height"
        val WEIGHT = "weight"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            var height = binding.txtHeight.text.toString()
            var weight = binding.txtWeight.text.toString()

//            if (height.length == 0 || weight.length == 0) return@setOnClickListener
            if (height.isNotBlank() && weight.isNotBlank()) {
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra(HEIGHT, height.toFloat())
                    putExtra(WEIGHT, weight.toFloat())
                }
                startActivity(intent)
            }
            else {
                var toast = Toast.makeText(application,
                    "키와 몸무게를 제대로 입력해주세요 ! 키 : ${height}, 몸무게 : ${weight}",
                    Toast.LENGTH_LONG).show()
            }
        }
    }
}