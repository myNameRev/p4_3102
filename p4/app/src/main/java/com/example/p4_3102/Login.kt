package com.example.p4_3102

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val et_Username: EditText = findViewById (R.id.et_Username)
        val et_pass: EditText = findViewById (R.id.et_Pass)
        val btn_login: Button = findViewById (R.id.btn_login)
        val btn_register: Button = findViewById(R.id.btn_register)

        btn_login.setOnClickListener {
            val username = et_Username.text.toString()

            val pindah : Intent= Intent(this dashboard::class.java)

            pindah.putExtra("nama", username)

            startActivity(pindah)
        }

        btn_register.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}