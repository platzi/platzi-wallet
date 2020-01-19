package com.cristianvillamil.platziwallet.ui.transfer

 class TransferAccount private constructor(
    var userName: String,
    var profilePhotoUrl: String,
    var bankName: String,
    var accountMaskedNumber: String,
    var isSelected: Boolean = false,
    var accountNumber: String,
    var accountId: String,
    var bankLogoUrl: String,
    var bankWebPageUrl: String,
    var lastTransferDate: String
) {
    class Builder(accountId: String) {
        private var userName: String = ""
        private var profilePhotoUrl: String = ""
        private var bankName: String = ""
        private var accountMaskedNumber: String = ""
        private var isSelected: Boolean = false
        private var accountNumber: String = ""
        private var accountId: String = ""
        private var bankLogoUrl: String = ""
        private var bankWebPageUrl: String = ""
        private var lastTransferDate: String = ""

        init {
            this.accountId = accountId
        }

        fun setUserName(newUserName: String): Builder = apply {
            this.userName = newUserName
        }

        fun setProfilePhotoUrl(profilePhotoUrl: String): Builder = apply {
            this.profilePhotoUrl = profilePhotoUrl
        }

        fun build(): TransferAccount =
            TransferAccount(
                userName,
                profilePhotoUrl,
                bankName,
                accountMaskedNumber,
                isSelected,
                accountNumber,
                accountId,
                bankLogoUrl,
                bankWebPageUrl,
                lastTransferDate
            )
    }
}