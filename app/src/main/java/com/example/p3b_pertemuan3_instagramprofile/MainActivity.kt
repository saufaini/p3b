package com.example.p3b_pertemuan3_instagramprofile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var imgProfile: ImageView
    private lateinit var txtUsername: TextView
    private lateinit var txtBio: TextView
    private lateinit var btnEditProfile: Button

    // Launcher untuk membuka EditProfileActivity dan menerima hasil edit (nama & bio)
    private val editProfileLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val newName = data?.getStringExtra(EditProfileActivity.EXTRA_NAME)
            val newBio = data?.getStringExtra(EditProfileActivity.EXTRA_BIO)

            if (!newName.isNullOrEmpty()) {
                txtUsername.text = newName
            }
            if (!newBio.isNullOrEmpty()) {
                txtBio.text = newBio
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imgProfile = findViewById(R.id.img_profile)
        txtUsername = findViewById(R.id.txt_username)
        txtBio = findViewById(R.id.txt_bio)
        btnEditProfile = findViewById(R.id.btn_edit_profile)

        // 1. Klik "Edit Profile" -> buka halaman edit nama & bio, tunggu hasilnya
        btnEditProfile.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            intent.putExtra(EditProfileActivity.EXTRA_NAME, txtUsername.text.toString())
            intent.putExtra(EditProfileActivity.EXTRA_BIO, txtBio.text.toString())
            editProfileLauncher.launch(intent)
        }

        // 2. Klik foto profil -> buka halaman detail foto & nama akun
        imgProfile.setOnClickListener {
            val intent = Intent(this, DetailFotoActivity::class.java)
            intent.putExtra(DetailFotoActivity.EXTRA_NAME, txtUsername.text.toString())
            startActivity(intent)
        }
    }
}
