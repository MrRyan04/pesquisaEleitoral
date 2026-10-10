package com.example.p1eleicoes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class resultadoActivity : AppCompatActivity() {

    private lateinit var totalentrevistados: TextView
    private lateinit var eleitores: Button
    private lateinit var resultados: Button
    private lateinit var limpar: Button
    private lateinit var sairresultados: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)

        totalentrevistados = findViewById(R.id.pessoasentrevistadas)
        eleitores = findViewById(R.id.eleitores)
        resultados = findViewById(R.id.resultado)
        limpar = findViewById(R.id.limpar)
        sairresultados = findViewById(R.id.sairresultados)

        totalentrevistados.text = GlobalData.totalinterview.toString()

        eleitores.setOnClickListener {
            val telaeleitores = Intent(this, eleitresdadosActivity::class.java)
            startActivity(telaeleitores)
        }

        resultados.setOnClickListener {
            val telagraph = Intent(this, graficoActivity::class.java)
            startActivity(telagraph)
        }

        sairresultados.setOnClickListener {
            val telalogin = Intent(this, loginActivity::class.java)
            startActivity(telalogin)
        }

        limpar.setOnClickListener {
            GlobalData.nomes.clear()
            GlobalData.telefones.clear()
            GlobalData.longitudes.clear()
            GlobalData.latitudes.clear()

            GlobalData.pablovotos = 0
            GlobalData.tayronevotos = 0
            GlobalData.austinvotos = 0
            GlobalData.uniquavotos = 0
            GlobalData.tashavotos = 0
            GlobalData.nulovotos = 0
            GlobalData.naoseivotos = 0
            GlobalData.brancovotos = 0

            GlobalData.i = 0
            GlobalData.totalinterview = 0
            totalentrevistados.text = GlobalData.totalinterview.toString()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sair)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}