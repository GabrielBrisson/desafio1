package com.me.projetoallan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import com.me.projetoallan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupEvents()

    }

    private fun setupEvents() = binding.apply {
        button1.setOnClickListener { et1.setText("Eu")}
        button2.setOnClickListener { et2.setText("vou") }
        button3.setOnClickListener { et3.setText("virar") }
        button4.setOnClickListener { et4.setText("dev") }
    }
}