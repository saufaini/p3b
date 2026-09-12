package com.example.p3b_pertemuan3_instagramprofile

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailFotoActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
    }

    private lateinit var txtName: TextView
    private lateinit var btnKembali: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_foto)

        txtName = findViewById(R.id.txt_detail_name)
        btnKembali = findViewById(R.id.btn_kembali)

        // Ambil nama akun yang dikirim dari MainActivity
        val name = intent.getStringExtra(EXTRA_NAME)
        txtName.text = name

        btnKembali.setOnClickListener {
            finish()
        }
    }
}
