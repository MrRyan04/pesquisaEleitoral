package com.example.p1eleicoes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast

class problemasActivity : AppCompatActivity() {

    private lateinit var saude: CheckBox
    private lateinit var educacao: CheckBox
    private lateinit var transporte: CheckBox
    private lateinit var violencia: CheckBox
    private lateinit var corrupcao: CheckBox
    private lateinit var desemprego: CheckBox
    private lateinit var industrializacao: CheckBox
    private lateinit var seguranca: CheckBox
    private lateinit var moradia: CheckBox
    private lateinit var meioambiente: CheckBox
    private lateinit var continuar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_problemas)

        saude = findViewById(R.id.saude)
        educacao = findViewById(R.id.educacao)
        transporte = findViewById(R.id.transporte)
        violencia = findViewById(R.id.violencia)
        corrupcao = findViewById(R.id.corrupcao)
        desemprego = findViewById(R.id.desemprego)
        industrializacao = findViewById(R.id.industrializacao)
        seguranca = findViewById(R.id.seguranca)
        moradia = findViewById(R.id.moradia)
        meioambiente = findViewById(R.id.meioambiente)
        continuar = findViewById(R.id.continuar)

        continuar.setOnClickListener {
            continuar.setOnClickListener {

                var quantidade = 0

                if (saude.isChecked) {
                    quantidade++
                }

                if (educacao.isChecked) {
                    quantidade++
                }

                if (transporte.isChecked) {
                    quantidade++
                }

                if (violencia.isChecked) {
                    quantidade++
                }

                if (corrupcao.isChecked) {
                    quantidade++
                }

                if (desemprego.isChecked) {
                    quantidade++
                }

                if (industrializacao.isChecked) {
                    quantidade++
                }

                if (seguranca.isChecked) {
                    quantidade++
                }

                if (moradia.isChecked) {
                    quantidade++
                }

                if (meioambiente.isChecked) {
                    quantidade++
                }

                if (quantidade > 3) {

                    Toast.makeText(
                        this,
                        "Escolha no maximo 3 problemas",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {

                    if (saude.isChecked) {
                        GlobalData.saudech++
                    }

                    if (educacao.isChecked) {
                        GlobalData.educacaoch++
                    }

                    if (transporte.isChecked) {
                        GlobalData.transportech++
                    }

                    if (violencia.isChecked) {
                        GlobalData.violenciach++
                    }

                    if (corrupcao.isChecked) {
                        GlobalData.corrpcaoch++
                    }

                    if (desemprego.isChecked) {
                        GlobalData.desempregoch++
                    }

                    if (industrializacao.isChecked) {
                        GlobalData.industrializacaoch++
                    }

                    if (seguranca.isChecked) {
                        GlobalData.segurancach++
                    }

                    if (moradia.isChecked) {
                        GlobalData.moradiach++
                    }

                    if (meioambiente.isChecked) {
                        GlobalData.meioambientech++
                    }

                    val telafinalizar = Intent(this, localizacaoActivity::class.java)
                    startActivity(telafinalizar)
                }
            }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sair)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(
                    systemBars.left,
                    systemBars.top,
                    systemBars.right,
                    systemBars.bottom
                )
                insets
            }
        }
    }
}