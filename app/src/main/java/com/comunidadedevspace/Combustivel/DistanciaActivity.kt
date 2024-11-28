package com.comunidadedevspace.Combustivel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_CONSUMO = "ConsumoActivity.KEY_CONSUMO"
class DistanciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val Preco = intent.getFloatExtra(KEY_PREÇO, 0f)
        val Consumo = intent.getFloatExtra(KEY_CONSUMO, 0f)

        val edtDistancia = findViewById<TextInputEditText>(R.id.edt_distancia)
        val btnResultado = findViewById<Button>(R.id.btn_resultado)

        btnResultado.setOnClickListener(){
            val StrDistancia = edtDistancia.text.toString()
            if (StrDistancia == ""){
                Snackbar
                    .make(
                        edtDistancia,
                        "Preencha o campo acima",
                        Snackbar.LENGTH_LONG
                    ).show()
            }else{
                val flDistancia = StrDistancia.toFloat()
                val resultado = (flDistancia / Consumo) * Preco
                val intent4 = Intent(this, ResultActivity::class.java)
                intent4.putExtra(KEY_RESULT, resultado)
                intent4.putExtra(KEY_DISTANCIA, flDistancia)
                intent4.putExtra(KEY_PREÇO, Preco)
                intent4.putExtra(KEY_CONSUMO, Consumo)
                startActivity(intent4)}
    }
        val btnVolt = findViewById<Button>(R.id.btn_voltar3)

        btnVolt.setOnClickListener(){
            val intent4 = Intent(this, MainActivity::class.java)
            startActivity(intent4)
        }
}
}