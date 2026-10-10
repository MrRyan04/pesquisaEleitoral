package com.example.p1eleicoes

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.location.*

class localizacaoActivity : AppCompatActivity() {

    private lateinit var pegarlocalizacao: Button
    private lateinit var sairlocalizacao: Button
    private lateinit var txtLatitude: TextView
    private lateinit var txtLongitude: TextView

    var latitude: Double = 0.0
    var longitude: Double = 0.0

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private var locationCallback: LocationCallback? = null

    private val pedirPermissao = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { foiConcedida ->
        if (foiConcedida) {
            iniciarCapturaLocalizacao()
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

        enableEdgeToEdge()
        setContentView(R.layout.activity_localizacao)

        pegarlocalizacao = findViewById(R.id.pegarlocalizacao)
        sairlocalizacao = findViewById(R.id.sairlocalizacao)
        txtLatitude = findViewById(R.id.txtLatitude)
        txtLongitude = findViewById(R.id.txtLongitude)

        fusedLocationClient =
            LocationServices.getFusedLocationProviderClient(this)

        pegarlocalizacao.setOnClickListener {
            verificarEPedirPermissao()
        }

        sairlocalizacao.setOnClickListener {
            if (GlobalData.pablovotos > 0) {
                GlobalData.pablovotos--
            }

            if (GlobalData.tayronevotos > 0) {
                GlobalData.tayronevotos--
            }

            if (GlobalData.austinvotos > 0) {
                GlobalData.austinvotos--
            }

            if (GlobalData.uniquavotos > 0) {
                GlobalData.uniquavotos--
            }

            if (GlobalData.tashavotos > 0) {
                GlobalData.tashavotos--
            }

            if (GlobalData.nulovotos > 0) {
                GlobalData.nulovotos--
            }

            if (GlobalData.naoseivotos > 0) {
                GlobalData.naoseivotos--
            }

            if (GlobalData.brancovotos > 0) {
                GlobalData.brancovotos--
            }

            val telalogin = Intent(
                this,
                voltarActivity::class.java
            )

            startActivity(telalogin)
        }

        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v, insets ->

            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }
    }

    private fun verificarEPedirPermissao() {

        if (
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {

            iniciarCapturaLocalizacao()

        } else {

            pedirPermissao.launch(
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        }
    }

    private fun iniciarCapturaLocalizacao() {

        val configuracao = LocationRequest.Builder(
            Priority.PRIORITY_HIGH_ACCURACY,
            3000
        ).build()

        locationCallback = object : LocationCallback() {

            override fun onLocationResult(
                resultado: LocationResult
            ) {

                val ultimaLocalizacao =
                    resultado.lastLocation

                if (ultimaLocalizacao != null) {

                    latitude = ultimaLocalizacao.latitude
                    longitude = ultimaLocalizacao.longitude

                    GlobalData.latitudes.add(
                        latitude.toString()
                    )

                    GlobalData.longitudes.add(
                        longitude.toString()
                    )

                    locationCallback?.let { callback ->
                        fusedLocationClient.removeLocationUpdates(
                            callback
                        )
                    }

                    val telafinalizar = Intent(
                        this@localizacaoActivity,
                        finalizarActivity::class.java
                    )

                    startActivity(telafinalizar)
                }
            }
        }

        try {

            fusedLocationClient.requestLocationUpdates(
                configuracao,
                locationCallback!!,
                Looper.getMainLooper()
            )

        } catch (e: SecurityException) {

            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        locationCallback?.let { callback ->
            fusedLocationClient.removeLocationUpdates(
                callback
            )
        }
    }
}