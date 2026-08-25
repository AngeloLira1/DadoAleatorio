package com.example.dadoaleatorio

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class DadoActivity : AppCompatActivity() {

    private val viewModel: DadoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLanzar = findViewById<Button>(R.id.btnLanzar)
        val tvNumero = findViewById<TextView>(R.id.tvNumero)
        val ivDado = findViewById<ImageView>(R.id.ivDado)

        btnLanzar.setOnClickListener {
            viewModel.lanzar()
        }

        // Reto: Uso de when dentro del observer para cambiar la imagen según el número
        viewModel.numeroDado.observe(this) { numero ->
            tvNumero.text = numero.toString()

            val drawableRes = when (numero) {
                1 -> R.drawable.dado_1
                2 -> R.drawable.dado_2
                3 -> R.drawable.dado_3
                4 -> R.drawable.dado_4
                5 -> R.drawable.dado_5
                6 -> R.drawable.dado_6
                else -> R.drawable.dado_1
            }
            ivDado.setImageResource(drawableRes)
        }
    }
}