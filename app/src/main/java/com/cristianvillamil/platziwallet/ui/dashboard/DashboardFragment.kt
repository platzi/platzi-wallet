package com.cristianvillamil.platziwallet.ui.dashboard

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cristianvillamil.platziwallet.R
import kotlinx.android.synthetic.main.fragment_transfer.*
import java.text.NumberFormat

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var current = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_transfer, container, false)
        dashboardViewModel.text.observe(this, Observer {
        })
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        amountValueInputEditText.onFocusChangeListener =
            View.OnFocusChangeListener { _, hasFocus ->
                if (hasFocus && amountValueInputEditText.text.toString().isBlank()) {
                    amountValueInputEditText.setText("\$ ")
                }
            }
        amountValueInputEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s.toString().let { text ->
                    if (!text.isBlank() && text != current) {
                        amountValueInputEditText.removeTextChangedListener(this)
                        val cleanString = text.replace("[\$,.\\s]".toRegex(), "")
                        if (cleanString.isBlank()) {
                            amountValueInputEditText.setText("\$ ")
                            amountValueInputEditText.addTextChangedListener(this)
                            amountValueInputEditText.setSelection(amountValueInputEditText.text.toString().length)
                        } else {
                            val parsed = cleanString.toDouble()
                            val formatted = NumberFormat.getCurrencyInstance().format((parsed))
                            current = formatted
                            amountValueInputEditText.setText(formatted)
                            amountValueInputEditText.setSelection(formatted.length)
                            amountValueInputEditText.addTextChangedListener(this)
                        }

                    }
                }
            }
        })
    }
}