package com.example.examenpatrick2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculadoraActivity : AppCompatActivity() {
    private lateinit var calculadoraTextView: TextView
    private lateinit var usuarioTextView: TextView
    private lateinit var txtNum1EditText: EditText
    private lateinit var txtNum2EditText: EditText
    private lateinit var resultadoTextView: TextView
    private lateinit var btnPlus: Button
    private lateinit var btnMinus: Button
    private lateinit var btnDivide: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnCerrar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)
        inicializarComponentes()
        eventoClic()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public fun inicializarComponentes() {
        calculadoraTextView = findViewById(R.id.Calculadora)
        usuarioTextView = findViewById(R.id.Usuario)
        txtNum1EditText = findViewById(R.id.txtNum1)
        txtNum2EditText = findViewById(R.id.txtNum2)
        resultadoTextView = findViewById(R.id.resultado)
        btnPlus = findViewById(R.id.btnPlus)
        btnMinus = findViewById(R.id.btnMinus)
        btnDivide = findViewById(R.id.btnDivide)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnCerrar = findViewById(R.id.btnCerrar)

        val strUsuario = intent.getStringExtra("Usuario")?: "Usuario desconocido"
        usuarioTextView.setText("Usuario: $strUsuario")
    }
    public fun eventoClic() {
        btnPlus.setOnClickListener {
            realizarOperacion("+")
        }

        btnMinus.setOnClickListener {
            realizarOperacion("-")
        }

        btnDivide.setOnClickListener {
            realizarOperacion("/")
        }

        btnMultiply.setOnClickListener {
            realizarOperacion("*")
        }

        btnLimpiar.setOnClickListener {
            txtNum1EditText.text.clear()
            txtNum2EditText.text.clear()
            resultadoTextView.text = "Resultado"
        }
        btnCerrar.setOnClickListener {
            finish()
        }
    }
    private fun realizarOperacion(operador: String) {
        val num1 = txtNum1EditText.text.toString().toDoubleOrNull()
        val num2 = txtNum2EditText.text.toString().toDoubleOrNull()
        if (num1 == null || num2 == null) {
            resultadoTextView.text = "Por favor, ingrese números válidos"
            return
        }
        val resultado = when (operador) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "/" -> if (num2 != 0.0) num1 / num2 else Double.NaN
            "*" -> num1 * num2
            else -> 0.0
        }
        resultadoTextView.text = "Resultado: $resultado"
    }
    }
