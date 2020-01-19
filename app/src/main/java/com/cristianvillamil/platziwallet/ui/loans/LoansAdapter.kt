package com.cristianvillamil.platziwallet.ui.loans

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cristianvillamil.platziwallet.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.loan_row.view.*

class LoansAdapter : RecyclerView.Adapter<LoanViewHolder>() {
    private var loansList = emptyList<Loan>()

    fun setData(dataList: List<Loan>) {
        loansList = dataList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.loan_row, parent, false)
        return LoanViewHolder(view);
    }

    override fun getItemCount(): Int = loansList.size

    override fun onBindViewHolder(holder: LoanViewHolder, position: Int) =
        holder.bindItem(loansList[position])

}

class LoanViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bindItem(loan: Loan) = with(view) {
        Picasso
            .get()
            .load("https://tickera-wpsalad.netdna-ssl.com/wp-content/themes/tickera/style/img/freebies/icons/events/24.png")
            .into(loanImageView)

    }
}

data class Loan(
    val typeName: String,
    val totalPaidAmount: Double,
    val paidAmount: Double,
    val loanNumber: String
)