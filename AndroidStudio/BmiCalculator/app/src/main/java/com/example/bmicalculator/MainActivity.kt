package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    companion object {
        val HEIGHT = "height"
        val WEIGHT = "weight"
        val BMI = "BMI"

        val KEY_HEIGHT = "KEY_HEIGHT"
        val KEY_WEIGHT = "KEY_WEIGHT"
        val KEY_BMI = "KEY_BMI"

        val REQUEST = 1
        val RESULT = "RESULT"
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != REQUEST) return

        Log.d("Result", data.toString())

        data?.getStringExtra(RESULT).let {
            binding.txtBmi.text = it
            it?.toFloat()?.let { it1 -> saveData(it1) }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadData()

        binding.button.setOnClickListener {
            var height = binding.txtHeight.text.toString()
            var weight = binding.txtWeight.text.toString()

//            if (height.length == 0 || weight.length == 0) return@setOnClickListener
            if (height.isNotBlank() && weight.isNotBlank()) {
                saveData(height.toFloat(), weight.toFloat())

                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra(HEIGHT, height.toFloat())
                    putExtra(WEIGHT, weight.toFloat())
                }
                startActivityForResult(intent, REQUEST)
            }
            else {
                var toast = Toast.makeText(application,
                    "키와 몸무게를 제대로 입력해주세요 ! 키 : ${height}, 몸무게 : ${weight}",
                    Toast.LENGTH_LONG).show()
            }
        }
    }

    fun saveData(height: Float, weight: Float) {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()

        editor.putFloat(KEY_HEIGHT, height)
            .putFloat(KEY_WEIGHT, weight)
            .apply()
    }

    fun saveData(bmi: Float) {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()

        editor.putFloat(KEY_BMI, bmi)
            .apply()
    }

    fun loadData() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val height = pref.getFloat(KEY_HEIGHT, 0f)
        val weight = pref.getFloat(KEY_WEIGHT, 0f)
        val bmi = pref.getFloat(KEY_BMI, 0f)

        if (height != 0f && weight != 0f && bmi != 0f) {
            binding.txtHeight.setText(height.toString())
            binding.txtWeight.setText(weight.toString())
            binding.txtBmi.text = bmi.toString()
        }
    }
}