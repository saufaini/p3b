package com.example.p3b_pertemuan4_activityintent

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.p3b_pertemuan4_activityintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inisiasi binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // set ui content
        setContentView(binding.root)

        //gumanakan binding
        with(binding) {
            btnToScondActivity.setOnClickListener {
                val intentToSecondActivity =
                    Intent(this@MainActivity, SecondActivity::class.java)

                intentToSecondActivity.putExtra("EXTRA_NAME", edtName.text.toString())
                startActivity(intentToSecondActivity)
            }

        }


    }
}


//private val TAG = "MainActivityLifecycle"
//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(R.layout.activity_main)
//    Log.d(TAG, "onCreate: dipanggil")
//}
//override fun onStart() {
//    super.onStart()
//    Log.d(TAG, "onStart: dipanggil")
//}
//override fun onResume() {
//    super.onResume()
//    Log.d(TAG, "onResume: dipanggil")
//}
//override fun onPause() {
//    super.onPause()
//    Log.d(TAG, "onPause: dipanggil")
//}
//override fun onStop() {
//    super.onStop()
//    Log.d(TAG, "onStop: dipanggil")
//}
//override fun onDestroy() {
//    super.onDestroy()
//    Log.d(TAG, "onDestroy: dipanggil")
//}