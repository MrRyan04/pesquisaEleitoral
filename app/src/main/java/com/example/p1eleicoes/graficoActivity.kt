package com.example.p1eleicoes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class graficoActivity : AppCompatActivity() {

    private lateinit var qntentrevista: TextView
    private lateinit var sairdaqui: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grafico)

        sairdaqui = findViewById(R.id.sairgraph)

        qntentrevista = findViewById(R.id.qntentrevista)

        var total = GlobalData.pablovotos + GlobalData.tayronevotos + GlobalData.austinvotos + GlobalData.uniquavotos + GlobalData.tashavotos

        qntentrevista.text = total.toString()

        var pablopercent = (GlobalData.pablovotos * 100f) / total
        val tayronepercent = (GlobalData.tayronevotos * 100f) / total
        val austinpercent = (GlobalData.austinvotos * 100f) / total
        val uniquapercent = (GlobalData.uniquavotos * 100f) / total
        val tashapercent = (GlobalData.tashavotos * 100f) / total
        val nulopercent = (GlobalData.nulovotos * 100f) / total
        val brancospercent = (GlobalData.brancovotos * 100f) / total
        val naoseipercent = (GlobalData.naoseivotos * 100f) / total

        val dadosGrafico = mapOf(
            "Pablo" to pablopercent,
            "Tayrone" to tayronepercent,
            "Austin" to austinpercent,
            "Uniqua" to uniquapercent,
            "Tasha" to tashapercent,
            "Nulos" to nulopercent,
            "Brancos" to brancospercent,
            "Nao sei" to naoseipercent
        )

        val chartView = findViewById<BarChartView>(R.id.barChartView)
        chartView.setData(dadosGrafico)

        sairdaqui.setOnClickListener {
            val telavoltara = Intent(this, resultadoActivity::class.java)
            startActivity(telavoltara)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sair)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}