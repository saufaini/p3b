package com.example.p3b_pertemuan3_instagramprofile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_BIO = "extra_bio"
    }

    private lateinit var etName: EditText
    private lateinit var etBio: EditText
    private lateinit var btnSimpan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        etName = findViewById(R.id.et_name)
        etBio = findViewById(R.id.et_bio)
        btnSimpan = findViewById(R.id.btn_simpan)

        // Ambil data nama & bio saat ini yang dikirim dari MainActivity
        val currentName = intent.getStringExtra(EXTRA_NAME)
        val currentBio = intent.getStringExtra(EXTRA_BIO)

        etName.setText(currentName)
        etBio.setText(currentBio)

        btnSimpan.setOnClickListener {
            // Kirim balik data yang sudah diedit ke MainActivity
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_NAME, etName.text.toString())
            resultIntent.putExtra(EXTRA_BIO, etBio.text.toString())
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
