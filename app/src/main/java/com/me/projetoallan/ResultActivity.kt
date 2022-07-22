package com.me.projetoallan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.me.projetoallan.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private var imc = 0F
    private var diagnostico = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imc = intent.getFloatExtra("EXTRA_IMC", 0F)
        validateDiagnostic(imc)
        setupScreen()
        setupClicks()
    }

    private fun validateDiagnostic(imc: Float) {
        diagnostico = when (imc) {
            in 0F..18.5F -> "Magreza"
            in 18.5F..24.9F -> "Normal"
            in 25F..29.9F -> "Sobrepeso"
            in 30F..39.9F -> "Obesidade"
            else -> "Obesidade Grave"
        }

        when (diagnostico) {
            "Magreza" -> setScreenBackground(R.color.yellow)
            "Normal" -> setScreenBackground(R.color.blue)
            "Sobrepeso" -> setScreenBackground(R.color.yellow)
            "Obesidade" -> setScreenBackground(R.color.red)
            "Obesidade Grave" -> setScreenBackground(R.color.dark_red)
        }
    }

    private fun setScreenBackground(color: Int) {
        binding.layoutResult.setBackgroundColor(ContextCompat.getColor(this, color))
    }

    private fun setupScreen() = binding.apply {
        textDiagnostico.text = diagnostico
        textResultado.text = imc.toString()
    }

    private fun setupClicks() = binding.apply {
        btnRecalcular.setOnClickListener {
            Intent(this@ResultActivity, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}