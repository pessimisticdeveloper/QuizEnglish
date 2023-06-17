package com.example.quizenglish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class OpenActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open)

        Handler().postDelayed({
            val intent = Intent(this, EntranceActivity::class.java)
            startActivity(intent)
            finish()
        },SPLASH_TIME_OUT)
    }
}