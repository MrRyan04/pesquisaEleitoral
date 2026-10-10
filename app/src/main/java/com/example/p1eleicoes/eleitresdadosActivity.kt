package com.example.p1eleicoes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class eleitresdadosActivity : AppCompatActivity() {

    private lateinit var nomeone: TextView
    private lateinit var telefoneone: TextView

    private lateinit var latititudeempty: TextView
    private lateinit var longitudeempty: TextView

    //private lateinit var anterior: Button

    private lateinit var proximo: Button
    private lateinit var saireleit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_eleitresdados)

        nomeone = findViewById(R.id.nomeone)
        telefoneone = findViewById(R.id.telefoneone)
       // anterior = findViewById(R.id.anterior)
        proximo = findViewById(R.id.proximo)
        latititudeempty = findViewById(R.id.latitudeempty)
        longitudeempty = findViewById(R.id.longitudeempty)
        saireleit = findViewById(R.id.saireleit)

        GlobalData.i = 0

        if (GlobalData.nomes.isNotEmpty() && GlobalData.telefones.isNotEmpty() && GlobalData.latitudes.isNotEmpty() && GlobalData.longitudes.isNotEmpty()){
            nomeone.text = GlobalData.nomes[GlobalData.i]
            telefoneone.text = GlobalData.telefones[GlobalData.i]
            latititudeempty.text = GlobalData.latitudes[GlobalData.i]
            longitudeempty.text = GlobalData.longitudes[GlobalData.i]

            proximo.setOnClickListener {

                if (GlobalData.i < GlobalData.totalinterview){

                    GlobalData.i++
                    if (GlobalData.i >= GlobalData.totalinterview){
                        GlobalData.i = 0
                    }

                    nomeone.text = GlobalData.nomes[GlobalData.i]
                    telefoneone.text = GlobalData.telefones[GlobalData.i]
                    latititudeempty.text = GlobalData.latitudes[GlobalData.i]
                    longitudeempty.text = GlobalData.longitudes[GlobalData.i]

                }
            }

        }


        saireleit.setOnClickListener {
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