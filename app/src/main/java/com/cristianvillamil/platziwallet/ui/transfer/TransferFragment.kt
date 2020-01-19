package com.cristianvillamil.platziwallet.ui.transfer

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cristianvillamil.platziwallet.R
import kotlinx.android.synthetic.main.fragment_transfer.*
import java.text.NumberFormat

class TransferFragment : Fragment() {

    private val DOLLAR_SYMBOL = "\$ "
    private val CLEAN_STRING_REGEX_PATTERN = "[\$,.\\s]".toRegex()
    private lateinit var dashboardViewModel: DashboardViewModel
    private var current = ""
    private var selectedTransferAccount: TransferAccount? = null

    private val onItemSelectedListener: OnItemSelected<TransferAccount> =
        object : OnItemSelected<TransferAccount> {
            override fun onItemSelected(item: TransferAccount) {
                selectedTransferAccount = item
                item.isSelected = true
                transferAccountsAdapter.unSelectAllDistinctTo(item)
                transferAccountsAdapter.notifyDataSetChanged()
                transferButton.isEnabled = true
            }
        }
    private val transferAccountsAdapter = TransferAccountsAdapter(onItemSelectedListener)

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
        initAmountInputEditText()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        transferAccountsRecyclerView.layoutManager = LinearLayoutManager(context)
        transferAccountsRecyclerView.adapter = transferAccountsAdapter
        val transferAccount = TransferAccount.Builder("12345")
            .setProfilePhotoUrl("htttps://www.google.com/imagenDePrueba")
            .setUserName("Paquito Perez")
            .build()
        val transferAccountList = listOf(transferAccount)
        /*val transferAccountList = listOf(
            TransferAccount("", "", "", "", false,"","","","",""),
            TransferAccount("", "", "", "", false,"","","","",""),
            TransferAccount("", "", "", "", false,"","","","",""),
            TransferAccount("", "", "", "", false,"","","","",""),
            TransferAccount("", "", "", "", false,"","","","","")
        )*/
        transferAccountsAdapter.setTransferAccountList(transferAccountList)
    }

    private fun initAmountInputEditText() {
        amountValueInputEditText.onFocusChangeListener =
            View.OnFocusChangeListener { _, hasFocus ->
                if (hasFocus && amountValueInputEditText.text.toString().isBlank()) {
                    amountValueInputEditText.setText(DOLLAR_SYMBOL)
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
                        val cleanString = text.replace(CLEAN_STRING_REGEX_PATTERN, "")
                        if (cleanString.isBlank()) {
                            amountValueInputEditText.setText(DOLLAR_SYMBOL)
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