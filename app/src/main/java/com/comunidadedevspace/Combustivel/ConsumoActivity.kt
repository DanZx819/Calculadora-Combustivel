package com.comunidadedevspace.Combustivel

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_PREÇO = "PrecoActivity.KEY_PRECO"
class ConsumoActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val preco = intent.getFloatExtra(KEY_PREÇO, 0f)

        val edtConsumo = findViewById<TextInputEditText>(R.id.edt_consumo)
        val btnProx2 = findViewById<Button>(R.id.btn_prox2)

        btnProx2.setOnClickListener(){
            val StrConsumo = edtConsumo.text.toString()

            if (StrConsumo == ""){
                Snackbar
                    .make(
                        edtConsumo,
                        "Preencha o campo acima",
                        Snackbar.LENGTH_LONG
                    ).show()
            }else{
                val flConsumo = StrConsumo.toFloat()
                val intent3 = Intent(this, DistanciaActivity::class.java)
                intent3.putExtra(KEY_CONSUMO, flConsumo)
                intent3.putExtra(KEY_PREÇO, preco)
                startActivity(intent3)
            }
        }
        val btnVolt = findViewById<Button>(R.id.btn_voltar2)

        btnVolt.setOnClickListener(){
            val intent3 = Intent(this, MainActivity::class.java)
            startActivity(intent3)
        }
    }
}