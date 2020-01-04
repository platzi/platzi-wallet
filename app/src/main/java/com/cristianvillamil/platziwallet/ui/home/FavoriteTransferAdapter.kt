package com.cristianvillamil.platziwallet.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cristianvillamil.platziwallet.R

class FavoriteTransferAdapter : RecyclerView.Adapter<FavoriteTransferViewHolder>() {

    private lateinit var favoriteTransferItems: List<FavoriteTransfer>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTransferViewHolder =
            FavoriteTransferViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                            R.layout.favorite_transfer_row,
                            parent,
                            false
                    )
            )


    override fun getItemCount(): Int = favoriteTransferItems.size

    override fun onBindViewHolder(holder: FavoriteTransferViewHolder, position: Int) =
            holder.bind(favoriteTransferItems[position])

    fun setData(favoriteTransferItems: List<FavoriteTransfer>) {
        this.favoriteTransferItems = favoriteTransferItems
        notifyDataSetChanged()
    }


}