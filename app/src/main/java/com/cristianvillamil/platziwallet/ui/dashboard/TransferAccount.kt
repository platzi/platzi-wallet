package com.cristianvillamil.platziwallet.ui.dashboard

data class TransferAccount(
    val userName: String,
    val profilePhotoUrl: String,
    val bankName: String,
    val accountMaskedNumber: String,
    var isSelected: Boolean = false
)