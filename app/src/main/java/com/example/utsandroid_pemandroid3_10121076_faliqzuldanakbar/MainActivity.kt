package com.example.utsandroid_pemandroid3_10121076_faliqzuldanakbar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() { //10121076 - Faliq Zuldan Akbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val nextButton: Button = findViewById(R.id.button2)
        val editTextDate: EditText = findViewById(R.id.editTextDate)
        val editTextNIK: EditText = findViewById(R.id.editTextText)
        val editTextNama: EditText = findViewById(R.id.editTextText2)
        val editTextTglLahir: EditText = findViewById(R.id.editTextDate3)
        val radioGroupJenisTes: RadioGroup = findViewById(R.id.radioGroup)
        val radioGroupJenisKelamin: RadioGroup = findViewById(R.id.radioGroup2)
        val radioGroupHubungan: RadioGroup = findViewById(R.id.radioGroup3)

        nextButton.setOnClickListener {

            val date = editTextDate.text.toString()
            val nik = editTextNIK.text.toString()
            val nama = editTextNama.text.toString()
            val tglLahir = editTextTglLahir.text.toString()

            // Get the selected radio buttons' text
            val selectedJenisTesId = radioGroupJenisTes.checkedRadioButtonId
            val selectedJenisTes = if (selectedJenisTesId != -1) {
                findViewById<RadioButton>(selectedJenisTesId).text.toString()
            } else {
                null
            }

            val selectedJenisKelaminId = radioGroupJenisKelamin.checkedRadioButtonId
            val selectedJenisKelamin = if (selectedJenisKelaminId != -1) {
                findViewById<RadioButton>(selectedJenisKelaminId).text.toString()
            } else {
                null
            }

            val selectedHubunganId = radioGroupHubungan.checkedRadioButtonId
            val selectedHubungan = if (selectedHubunganId != -1) {
                findViewById<RadioButton>(selectedHubunganId).text.toString()
            } else {
                null
            }

            // Check if all required fields are filled
            if (date.isNotEmpty() && nik.isNotEmpty() && nama.isNotEmpty() && tglLahir.isNotEmpty() &&
                selectedJenisTes != null && selectedJenisKelamin != null && selectedHubungan != null) {

                val intent = Intent(this, Halaman2::class.java)
                intent.putExtra("DATE", date)
                intent.putExtra("NIK", nik)
                intent.putExtra("NAMA", nama)
                intent.putExtra("TGL_LAHIR", tglLahir)
                intent.putExtra("JENIS_TES", selectedJenisTes)
                intent.putExtra("JENIS_KELAMIN", selectedJenisKelamin)
                intent.putExtra("HUBUNGAN", selectedHubungan)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Semua bidang harus diisi", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
