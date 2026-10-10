package com.example.p1eleicoes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class finalizarActivity : AppCompatActivity() {

    private lateinit var nomeentrevistado: EditText
    private lateinit var telefoneentrevistado: EditText
    private lateinit var finalizar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_finalizar)


        nomeentrevistado = findViewById(R.id.nomeentrevistado)
        telefoneentrevistado = findViewById(R.id.telefoneentrevistado)
        finalizar = findViewById(R.id.finalizar)

        finalizar.setOnClickListener {
            var nome: String = nomeentrevistado.text.toString()
            var telefone: String = telefoneentrevistado.text.toString()

            if (nome.isNotBlank() && telefone.isNotBlank()){
                //var longitude =
                //var latitude =

                GlobalData.nomes.add(nome)
                GlobalData.telefones.add(telefone)

                GlobalData.totalinterview++

                val ask = Intent(this, voltarActivity::class.java)
                startActivity(ask)
            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sair)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}