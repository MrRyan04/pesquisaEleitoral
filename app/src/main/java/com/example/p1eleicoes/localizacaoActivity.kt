package com.example.p1eleicoes

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Looper
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.location.*

class localizacaoActivity : AppCompatActivity() {

    private lateinit var eleitorLocalizacao: FusedLocationProviderClient
    private var callback: LocationCallback? = null

    private val pedirPermissao = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { concedida ->
        if (concedida) {
            iniciarLocalizacao()
        } else {
            Toast.makeText(
                this,
                "Permissão de localização negada",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localizacao)

        eleitorLocalizacao =
            LocationServices.getFusedLocationProviderClient(this)

        findViewById<android.widget.Button>(R.id.pegarlocalizacao)
            .setOnClickListener {

                if (ContextCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    iniciarLocalizacao()
                } else {
                    pedirPermissao.launch(
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )
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

    private fun iniciarLocalizacao() {
        val requisicao = LocationRequest.Builder(
            Priority.PRIORITY_HIGH_ACCURACY, 3000
        ).build()

        val novoCallback = object : LocationCallback() {
            override fun onLocationResult(resultado: LocationResult) {
                val localizacao = resultado.lastLocation

                if (localizacao == null) {
                    return
                }

                GlobalData.latitudes.add(localizacao.latitude.toString())
                GlobalData.longitudes.add(localizacao.longitude.toString())

                eleitorLocalizacao.removeLocationUpdates(this)
                callback = null

                val telafinalizar = Intent(
                    this@localizacaoActivity,
                    finalizarActivity::class.java
                )
                startActivity(telafinalizar)
            }
        }

        callback = novoCallback

        eleitorLocalizacao.requestLocationUpdates(
            requisicao,
            novoCallback,
            Looper.getMainLooper()
        )
    }
}