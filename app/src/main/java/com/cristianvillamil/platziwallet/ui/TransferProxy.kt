package com.cristianvillamil.platziwallet.ui

class TransferProxy {
    val MAX_TRANFER_AMOUNT = 1000000
    val MIN_TRANSFER_AMOUNT = 100

    fun checkTransfer(amount: Double) : String{
        return when {
            amount > MAX_TRANFER_AMOUNT -> {
                "La transacción excede el monto"
            }
            amount < MIN_TRANSFER_AMOUNT -> {
                "La transaccion debe ser mayor $MIN_TRANSFER_AMOUNT"
            }
            else -> {
                doTransfer(amount)
                "La transferencia se hizo correctamente"
            }
        }
    }

    private fun doTransfer(amount: Double){

    }
}