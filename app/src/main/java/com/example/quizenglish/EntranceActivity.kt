package com.example.quizenglish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EntranceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)

        val baslat : Button = findViewById(R.id.baslat)

        baslat.setOnClickListener {
            val intent = Intent(this,QuestionsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}