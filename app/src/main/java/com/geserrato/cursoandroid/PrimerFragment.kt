package com.geserrato.cursoandroid

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener


/**
 * A simple [Fragment] subclass.
 * Use the [PrimerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PrimerFragment : Fragment(R.layout.fragment_primer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.btn_navegar)
        val resultado = view.findViewById<TextView>(R.id.txt_output)

        setFragmentResultListener("requestKey") { key, bundle ->
            val result = bundle.getString("bundleKey")
            resultado.text = result
        }

        button.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
//                add(R.id.fragment_container_view, SegundoFragment() // Agregamos un fragment arriba del que ya tenemos
                replace(
                    R.id.fragment_container_view,
                    SegundoFragment.newInstance("Gerardo", 30)
                ) // Remplaza el fragment
                addToBackStack("primerFragment")
            }
        }
    }
}