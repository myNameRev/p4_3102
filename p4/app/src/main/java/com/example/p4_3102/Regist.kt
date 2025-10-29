package com.example.p4_3102

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Regist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.regist)

        val et_nama: EditText = findViewById(R.id.et_nama)
        val et_RegUsername: EditText = findViewById(R.id.et_reg_username)
        val et_RegEmail: EditText = findViewById(R.id.et_reg_email)
        val et_RegPassword: EditText = findViewById(R.id.et_reg_password)
        val et_RegConfirmPassword: EditText = findViewById(R.id.et_reg_confirm_password)
        val btn_Register: Button = findViewById(R.id.btn_register)
        val rg_jenis_kelamin: RadioGroup = findViewById(R.id.rg_jenis_kelamin)
        val cb_syarat: CheckBox = findViewById(R.id.syarat_ketentuan)
        val spinner_domisili: Spinner = findViewById(R.id.spinner_domisili)

        btn_Register.setOnClickListener {
            val selectedJkId = rg_jenis_kelamin.checkedRadioButtonId

            val jenisKelamin = when (selectedJkId) {
                R.id.pria -> "Pria"
                R.id.wanita -> "Wanita"
                else -> "Belum dipilih"
            }

            val setuju = cb_syarat.isChecked

            val domisili = spinner_domisili.selectedItem.toString()
            val domisiliPosition = spinner_domisili.selectedItemPosition // <- Dapatkan posisinya

            if (domisiliPosition == 0) {
                Toast.makeText(this, "Harap pilih domisili Anda!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    this,
                    "Jenis Kelamin: $jenisKelamin, Setuju: $setuju, Domisili: $domisili",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}