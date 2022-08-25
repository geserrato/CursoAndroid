package com.geserrato.cursoandroid

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult

class SegundoFragment : Fragment(R.layout.fragment_segundo) {

    private var nombre: String? = null
    private var edad: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nombre = requireArguments().getString(MY_NAME)
        edad = requireArguments().getInt(MY_AGE)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = view.findViewById<TextView>(R.id.txt_View)
        text.text = "$nombre $edad"
        val button = view.findViewById<Button>(R.id.btn_enviarDatos)
        button.setOnClickListener {
            val result = "Resultado otro valor"
            // bundleOf nos pide una clave valor
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
        }
    }

    companion object {
        private const val MY_NAME = "nombre"
        private const val MY_AGE = "edad"

        fun newInstance(nombre: String, edad: Int) = SegundoFragment().apply {
            arguments = bundleOf(MY_NAME to nombre, MY_AGE to edad)
        }
    }
}