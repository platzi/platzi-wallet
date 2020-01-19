package com.cristianvillamil.platziwallet.ui.transfer

import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cristianvillamil.platziwallet.R
import com.squareup.picasso.Picasso

class TransferAccountViewHolder(
    private val view: View,
    private val onItemSelectedListener: OnItemSelected<TransferAccount>
) : RecyclerView.ViewHolder(view) {

    fun bindItem(transferAccount: TransferAccount) {
        view.setOnClickListener {
            onItemSelectedListener.onItemSelected(transferAccount)
        }
        if (transferAccount.isSelected) {
            view.findViewById<CardView>(R.id.transferRowContainer)
                .setCardBackgroundColor(ContextCompat.getColor(view.context, R.color.primary))
        } else {
            view.findViewById<CardView>(R.id.transferRowContainer)
                .setCardBackgroundColor(ContextCompat.getColor(view.context, R.color.divider))
        }
        Picasso
            .get()
            .load("https://media.licdn.com/dms/image/C4E03AQFcCuDIJl0mKg/profile-displayphoto-shrink_200_200/0?e=1583366400&v=beta&t=ymt3xgMe5bKS-2knNDL9mQYFksP9ZHne5ugIqEyRjZs")
            .into(view.findViewById<ImageView>(R.id.profilePhotoImageView))
    }

}