package com.example.quizenglish

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class QuestionsActivity : AppCompatActivity() {
    var soruListe = Fixed.getQuestions()
    var soruNo : Int = 0
    var secilenYanit:MutableList<String> = mutableListOf("","","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val sorutv : TextView = findViewById(R.id.sorutv)
        val soruno : TextView = findViewById(R.id.soruno)
        val cevapA : Button = findViewById(R.id.cevapA)
        val cevapB : Button = findViewById(R.id.cevapB)
        val cevapC : Button = findViewById(R.id.cevapC)
        val cevapD : Button = findViewById(R.id.cevapD)
        val ivresim : ImageView = findViewById(R.id.ivresim)



        soruno.setText("${soruNo+1}/${soruListe.size}")
        soruGoster()
    }
    private fun soruGoster(){
        val sorutv : TextView = findViewById(R.id.sorutv)
        val cevapA : Button = findViewById(R.id.cevapA)
        val cevapB : Button = findViewById(R.id.cevapB)
        val cevapC : Button = findViewById(R.id.cevapC)
        val cevapD : Button = findViewById(R.id.cevapD)
        val ivresim : ImageView = findViewById(R.id.ivresim)
        var soru = soruListe[soruNo]
        sorutv.setText(soru.metinSoru)
        cevapA.setText(soru.a)
        cevapB.setText(soru.b)
        cevapC.setText(soru.c)
        cevapD.setText(soru.d)
        ivresim.setImageResource(soru.resim)
        isaretle()
    }
    private fun isaretle(){
        val sorutv : TextView = findViewById(R.id.sorutv)
        val cevapA : Button = findViewById(R.id.cevapA)
        val cevapB : Button = findViewById(R.id.cevapB)
        val cevapC : Button = findViewById(R.id.cevapC)
        val cevapD : Button = findViewById(R.id.cevapD)
        when(secilenYanit[soruNo]){
            "a" -> cevapA.setBackgroundColor(Color.GREEN)
            "b" -> cevapB.setBackgroundColor(Color.GREEN)
            "c" -> cevapC.setBackgroundColor(Color.GREEN)
            "d" -> cevapD.setBackgroundColor(Color.GREEN)
        }
        sorutv.setText(soruNo.toString()+"/3")
    }
    fun secim(v:View){
        val sorutv : TextView = findViewById(R.id.sorutv)
        val soruno : TextView = findViewById(R.id.soruno)
        val cevapA : Button = findViewById(R.id.cevapA)
        val cevapB : Button = findViewById(R.id.cevapB)
        val cevapC : Button = findViewById(R.id.cevapC)
        val cevapD : Button = findViewById(R.id.cevapD)
        val ivresim : ImageView = findViewById(R.id.ivresim)
        when(v.id){
            R.id.cevapA -> secilenYanit[soruNo] = "a"
            R.id.cevapB -> secilenYanit[soruNo] = "b"
            R.id.cevapC -> secilenYanit[soruNo] = "c"
            R.id.cevapD -> secilenYanit[soruNo] = "d"
        }
        isaretle()
        if (soruNo == 2){
            bitir(v)
        }else{
            ileri(v)
        }
    }
    fun ileri(v:View){
        if (soruNo < soruListe.size-1){
            soruNo++
            soruGoster()
        }
    }
    fun bitir(v:View){
        var dogruSayisi = 0
        for (i in 0..(soruListe.size-1)){
            if (secilenYanit[i] == soruListe[i].dogru){
                dogruSayisi++
            }
        }
        val intent = Intent(this,ReportActivity::class.java)
        intent.putExtra("Doğru Sayınız: ",dogruSayisi.toString())
        startActivity(intent)
        finish()
    }
}