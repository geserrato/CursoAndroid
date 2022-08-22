package com.geserrato.cursoandroid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var texto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Lifecycle", "onCreate: ")
        texto = findViewById(R.id.txt_output)
        val button = findViewById<Button>(R.id.btn_action)

        button.setOnClickListener {
            navegarSegundaActivity()
        }
    }

    private fun navegarSegundaActivity() {
        val intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("name", "Curso Android Intent")
        initActivity.launch(intent)
    }

    private val initActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                texto.text = it.data?.getStringExtra("name2")
            }
        }
}