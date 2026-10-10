package com.example.p1eleicoes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class loginActivity : AppCompatActivity() {

    private lateinit var user: EditText
    private lateinit var pass: EditText
    private lateinit var login: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        user = findViewById(R.id.usuario)
        pass = findViewById(R.id.senha)
        login = findViewById(R.id.entrar)


        login.setOnClickListener {
            val uservalue = user.text.toString()
            val passvalue = pass.text.toString()

            if (uservalue == "entrevistador" && passvalue == "entrevistador"){
                val telapesquisaintencao = Intent(this, pesquisaintencaoActivity::class.java)
                startActivity(telapesquisaintencao)
            }
            if (uservalue == "admin" && passvalue == "admin"){
                val telaresultados = Intent(this, resultadoActivity::class.java)
                startActivity(telaresultados)
            }
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sair)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}