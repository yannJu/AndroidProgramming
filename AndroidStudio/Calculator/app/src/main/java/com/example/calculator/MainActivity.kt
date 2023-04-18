package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calculator.databinding.ActivityMainBinding

const val TAG = "Calc-Main Activity"
class MainActivity : AppCompatActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    private fun subNumber(i: Int, i1: Int) = i - i1
    private fun addNumber(i: Int, i1: Int) = i + i1
    private fun calculate(pFun : (Int, Int) -> Int, num1: Int, num2: Int) = pFun(num1, num2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 더하기 버튼에 대한 이벤트 처리
        binding.btnPlus.setOnClickListener {
            var num1:String = binding.txtNum1.text.toString()
            var num2:String = binding.txtNum2.text.toString()

            if (num1.length == 0 || num2.length == 0) {
                Log.d(TAG, "정수변환이 되지 않습니다. (num1 : $num1, num2 : $num2)")
                return@setOnClickListener
            }
            var result = addNumber(num1.toInt(), num2.toInt())

            binding.txtResult.text = "$result"
        }

        // 빼기 버튼에 대한 이벤트 처리
        binding.btnMinus.setOnClickListener {
            var num1:String = binding.txtNum1.text.toString()
            var num2:String = binding.txtNum2.text.toString()

            if (num1.length == 0 || num2.length == 0) {
                Log.d(TAG, "정수변환이 되지 않습니다. (num1 : $num1, num2 : $num2)")
                return@setOnClickListener
            }
            var result = calculate(::subNumber, num1.toInt(), num2.toInt())

            binding.txtResult.text = "$result"
        }
    }
}