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

class PrecoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preco)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtPreco = findViewById<TextInputEditText>(R.id.edt_preco)

        val btnProx = findViewById<Button>(R.id.btn_prox1)

        btnProx.setOnClickListener(){
            val StrPreco = edtPreco.text.toString()
            if (StrPreco == ""){
                Snackbar
                    .make(
                        edtPreco,
                        "Preencha o campo acima",
                        Snackbar.LENGTH_LONG
                    ).show()
            }else{
                val flPreco = StrPreco.toFloat()

                val intent2 = Intent(this, ConsumoActivity::class.java)
                intent2.putExtra(KEY_PREÇO, flPreco)
                startActivity(intent2)
            }
        }
        val btnVolt = findViewById<Button>(R.id.btn_voltar1)

        btnVolt.setOnClickListener(){
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)
        }
    }
}