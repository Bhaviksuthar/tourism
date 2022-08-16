package com.example.tourismproject.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import com.example.tourismproject.R

class MainActivity : AppCompatActivity() {

    lateinit var progressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            startActivity(Intent(applicationContext, DashBoardActivity::class.java))
            finish()
        },3000)
    }
}