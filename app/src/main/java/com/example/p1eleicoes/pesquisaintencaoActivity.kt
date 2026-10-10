package com.example.p1eleicoes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class pesquisaintencaoActivity : AppCompatActivity() {

    private lateinit var seguir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pesquisaintencao)

        seguir = findViewById(R.id.seguir)

        seguir.setOnClickListener {
            val telacandidatos = Intent(this, estimuladasActivity::class.java)
            startActivity(telacandidatos)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sair)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}