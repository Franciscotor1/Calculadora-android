package com.example.examenpatrick2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var calculadoraTextView: TextView
    private lateinit var usuarioTextView: TextView
    private lateinit var txtUsuarioEditText: EditText
    private lateinit var contraseñaTextView: TextView
    private lateinit var txtContraseñaEditText: EditText
    private lateinit var btnEntrar: Button
    private lateinit var btnSalir: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        inicializarComponentes()
        eventosClic()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    public fun inicializarComponentes() {
        calculadoraTextView = findViewById(R.id.Calculadora)
        usuarioTextView = findViewById(R.id.Usuario)
        txtUsuarioEditText = findViewById(R.id.txtUsuario)
        contraseñaTextView = findViewById(R.id.Contraseña)
        txtContraseñaEditText = findViewById(R.id.txtContraseña)
        btnEntrar = findViewById(R.id.btnEntrar)
        btnSalir = findViewById(R.id.btnSalir)
    }
    public fun eventosClic() {
        btnEntrar.setOnClickListener(View.OnClickListener {
            if (txtUsuarioEditText.text.toString().contentEquals(charSequence = "")){
                Toast.makeText(this, "Falto capturar tu nombre", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, CalculadoraActivity::class.java)
                intent.putExtra("Usuario", txtUsuarioEditText.text.toString())
                if(txtContraseñaEditText.text.toString().contentEquals(charSequence = "")) {
                    Toast.makeText(this, "Falto capturar tu contraseña", Toast.LENGTH_SHORT).show()
                }else {
                    startActivity(intent)
                }
            } })
        btnSalir.setOnClickListener(View.OnClickListener {
            finish()
        })
    }    }