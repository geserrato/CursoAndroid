package com.geserrato.cursoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit

class MainActivityFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)
        supportFragmentManager.commit {
            setReorderingAllowed(true) // Esto nos sirve para que las transacciones se hagan una manera mas correcta
            add(R.id.fragment_container_view,PrimerFragment())
        }
    }
}