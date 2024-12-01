package com.comunidadedevspace.Combustivel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
const val KEY_RESULT = "DistanciaActivity.KEY_RESULT"
const val KEY_DISTANCIA = "DistanciaActivity.KEY_DISTANCIA"
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val resultado = intent.getFloatExtra(KEY_RESULT, 0f)
        val preco = intent.getFloatExtra(KEY_PREÇO, 0f)
        val consumo = intent.getFloatExtra(KEY_CONSUMO, 0f)
        val distancia = intent.getFloatExtra(KEY_DISTANCIA, 0f)

        val tv_resultado = findViewById<TextView>(R.id.vt_resultado)
        val tv_preco = findViewById<TextView>(R.id.vt_preco)
        val tv_consumo = findViewById<TextView>(R.id.vt_consumo)
        val tv_distancia = findViewById<TextView>(R.id.vt_distancia)

        tv_resultado.text = "R$%.2f".format(resultado)
        tv_preco.text = preco.toString()
        tv_consumo.text = consumo.toString()
        tv_distancia.text = distancia.toString()

        val btn_newcalc = findViewById<Button>(R.id.btn_newcalc)

        btn_newcalc.setOnClickListener(){
            val intentF = Intent(this, MainActivity::class.java)
            startActivity(intentF)
        }

    }

}