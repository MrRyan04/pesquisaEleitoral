package com.example.p1eleicoes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class voltarActivity : AppCompatActivity() {

    private lateinit var novapesquisa: Button
    private lateinit var voltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_voltar)

        novapesquisa = findViewById(R.id.novapesquisa)
        voltar = findViewById(R.id.voltar)


        novapesquisa.setOnClickListener {
            val telapesquisaintencao = Intent(this, pesquisaintencaoActivity::class.java)
            startActivity(telapesquisaintencao)
        }

        voltar.setOnClickListener {
            val telalogin = Intent(this, loginActivity::class.java)
            startActivity(telalogin)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sair)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}