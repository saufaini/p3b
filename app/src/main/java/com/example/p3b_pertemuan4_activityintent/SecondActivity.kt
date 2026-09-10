package com.example.p3b_pertemuan4_activityintent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.p3b_pertemuan4_activityintent.databinding.ActivitySecondBinding



class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            // Memeriksa result code
            if (result.resultCode == Activity.RESULT_OK) {

                // Mengambil data Intent
                val data = result.data

                // Mendapatkan alamat dari data Intent
                val name = data?.getStringExtra("EXTRA_NAME")
                val address = data?.getStringExtra("EXTRA_ADDRESS")

                // Menetapkan teks di TextView
                binding.txtName.text = "$name beralamat di $address"
            }
        }
    companion object{
        const val EXTRA_ADDRESS = "EXTRA_ADDRESS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("EXTRA_NAME")
        with(binding) {
            txtName.text = name

            btnToThirdActivity.setOnClickListener {
                val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
                    .apply { putExtra("EXTRA_NAME",name) }
                launcher.launch(intent)
            }
        }




    }
}

