package com.example.p1eleicoes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class estimuladasActivity : AppCompatActivity() {

    private lateinit var pablo: Button
    private lateinit var tayrone: Button
    private lateinit var austin: Button
    private lateinit var uniqua: Button
    private lateinit var tasha: Button
    private lateinit var branco: Button
    private lateinit var nulos: Button
    private lateinit var naosei: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_estimuladas)

        pablo = findViewById(R.id.pablo)
        tayrone = findViewById(R.id.tayrone)
        austin = findViewById(R.id.austin)
        uniqua = findViewById(R.id.uniqua)
        tasha = findViewById(R.id.tasha)
        branco = findViewById(R.id.branco)
        nulos = findViewById(R.id.nulo)
        naosei = findViewById(R.id.naosei)


        naosei.setOnClickListener {
            GlobalData.naoseivotos++
            val telaproblemas = Intent(this, problemasActivity::class.java)
            startActivity(telaproblemas)
        }

        nulos.setOnClickListener {
            GlobalData.nulovotos++
            val telaproblemas = Intent(this, problemasActivity::class.java)
            startActivity(telaproblemas)
        }

        branco.setOnClickListener {
            GlobalData.brancovotos++
            val telaproblemas = Intent(this, problemasActivity::class.java)
            startActivity(telaproblemas)
        }

        tasha.setOnClickListener {
            GlobalData.tashavotos++
            val telaproblemas = Intent(this, problemasActivity::class.java)
            startActivity(telaproblemas)
        }

        uniqua.setOnClickListener {
            GlobalData.uniquavotos++
            val telaproblemas = Intent(this, problemasActivity::class.java)
            startActivity(telaproblemas)
        }

        austin.setOnClickListener {
            GlobalData.austinvotos++
            val telaproblemas = Intent(this, problemasActivity::class.java)
            startActivity(telaproblemas)
        }

        tayrone.setOnClickListener {
            GlobalData.tayronevotos++
            val telaproblemas = Intent(this, problemasActivity::class.java)
            startActivity(telaproblemas)
        }

        pablo.setOnClickListener {
            GlobalData.pablovotos++
            val telaproblemas = Intent(this, problemasActivity::class.java)
            startActivity(telaproblemas)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sair)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}