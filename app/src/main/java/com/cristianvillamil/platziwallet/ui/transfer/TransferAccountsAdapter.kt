package com.cristianvillamil.platziwallet.ui.transfer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cristianvillamil.platziwallet.R

class TransferAccountsAdapter(private val onItemSelectedListener: OnItemSelected<TransferAccount>) :
    RecyclerView.Adapter<TransferAccountViewHolder>() {

    private var transferAccountList: List<TransferAccount> = emptyList()


    fun setTransferAccountList(transferAccountList: List<TransferAccount>) {
        this.transferAccountList = transferAccountList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransferAccountViewHolder =
        TransferAccountViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.transfer_row,
                parent,
                false
            ), onItemSelectedListener
        )


    override fun getItemCount(): Int = transferAccountList.size

    override fun onBindViewHolder(holder: TransferAccountViewHolder, position: Int) =
        holder.bindItem(transferAccountList[position])

    fun unSelectAllDistinctTo(transferAccount: TransferAccount) {
        transferAccountList
            .forEach {
                if (!(transferAccount === it)) {
                    it.isSelected = false
                }
            }
    }

}