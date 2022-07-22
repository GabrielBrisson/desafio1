package com.me.projetoallan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.me.projetoallan.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnCalcular.setOnClickListener {

            val imc = calculateImc()

            Intent(this@MainActivity, ResultActivity::class.java).also {
                it.putExtra("EXTRA_IMC", imc)
                startActivity(it)
            }
        }
    }

    private fun calculateImc(): Float {
        val altura = binding.sliderAltura.value
        val peso = binding.sliderPeso.value
        return peso / altura.pow(2)
    }
}