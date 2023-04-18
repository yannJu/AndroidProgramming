package com.example.uidesign_basic

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.uidesign_basic.databinding.EditTextBinding

class EditTextActivity : AppCompatActivity() {
    val binding by lazy { EditTextBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 이름 입력칸 ==============
        binding.inputName.setOnFocusChangeListener {v, hasFocus ->
            val edt = v as EditText
            val color = if (hasFocus) {
                Color.TRANSPARENT
            } else {
                Color.LTGRAY
            }

            edt.setBackgroundColor(color)
        }

        // 비밀번호 확인 text ================
        binding.inputPwd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.txtPwdCk.text = s
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }
}