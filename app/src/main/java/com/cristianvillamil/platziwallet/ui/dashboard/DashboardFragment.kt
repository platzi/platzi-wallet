package com.cristianvillamil.platziwallet.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cristianvillamil.platziwallet.R

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AlertDialog.Builder(context!!)
            .setTitle("Hola Builder")
            .setMessage("Aquí mostramos el mensaje del dialog.")
            .setNegativeButton("No Gracias", { dialogInterface, i ->
                // Línea de código para el click del botón negativo
            })
            .setPositiveButton("OK", { dialogInterface, i ->
                // Línea de código para el click del botón positivo
            })
            .show()
    }
}