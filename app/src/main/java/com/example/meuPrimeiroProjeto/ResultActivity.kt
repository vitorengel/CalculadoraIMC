package com.example.meuPrimeiroProjeto

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.helloworld.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.txtResult)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)
        val tvClassificacao = findViewById<TextView>(R.id.txtClassificacao)

        tvResult.text = result.toString()

        val classificacao = if (result < 18.5f) {
            "Abaixo do peso"
        }else if (result in 18.5f..24.9f){
            "Normal"
        }else if (result in 25f..29.9f){
            "Sobrepeso"
        }else if (result in 30f..39.9f){
            "Obesidade"
        }else {
            "Obesidade grave"
        }

            tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}