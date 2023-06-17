package com.example.quizenglish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ReportActivity : AppCompatActivity() {

    private lateinit var sonuclar: TextView
    private lateinit var restart : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        sonuclar.setText(intent.getStringExtra("doğru sayısı"))
        restart.setOnClickListener {
            val intent = Intent(this,EntranceActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}