package com.example.utsandroid_pemandroid3_10121076_faliqzuldanakbar

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Halaman2 : AppCompatActivity() { //10121076 - Faliq Zuldan Akbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val date = intent.getStringExtra("DATE")
        val nik = intent.getStringExtra("NIK")
        val nama = intent.getStringExtra("NAMA")
        val tglLahir = intent.getStringExtra("TGL_LAHIR")
        val jenisTes = intent.getStringExtra("JENIS_TES")
        val jenisKelamin = intent.getStringExtra("JENIS_KELAMIN")
        val hubungan = intent.getStringExtra("HUBUNGAN")

        val textViewDate: TextView = findViewById(R.id.textView13)
        val textViewNIK: TextView = findViewById(R.id.textView15)
        val textViewNama: TextView = findViewById(R.id.textView17)
        val textViewTglLahir: TextView = findViewById(R.id.textView19)
        val textViewJenisTes: TextView = findViewById(R.id.textView21)
        val textViewJenisKelamin: TextView = findViewById(R.id.textView23)
        val textViewHubungan: TextView = findViewById(R.id.textView25)

        textViewDate.text = date
        textViewNIK.text = nik
        textViewNama.text = nama
        textViewTglLahir.text = tglLahir
        textViewJenisTes.text = jenisTes
        textViewJenisKelamin.text = jenisKelamin
        textViewHubungan.text = hubungan

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nextButton: Button = findViewById(R.id.button)
        nextButton.setOnClickListener {
            tampilkanAlertDialog()
        }
    }

    private fun tampilkanAlertDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)

        val dialog = dialogBuilder.create()
        dialogView.findViewById<Button>(R.id.dialog_button_ok).setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}
