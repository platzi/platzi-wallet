package com.cristianvillamil.platziwallet.ui.transfer.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transfers")
data class TransferEntity(
    @ColumnInfo(name = "transaction_id")
    @PrimaryKey(autoGenerate = true)
    val transactionId: Int = 0,

    @ColumnInfo(name = "user_id")
    val userId: String,
    @ColumnInfo(name = "user_name")
    val userName: String,
    @ColumnInfo(name = "transaction_date")
    val transactionDate: String,
    @ColumnInfo(name = "transaction_amount")
    val transactionAmount: String,
    @ColumnInfo(name = "receiver_user_id")
    val receiverUserId: String
)