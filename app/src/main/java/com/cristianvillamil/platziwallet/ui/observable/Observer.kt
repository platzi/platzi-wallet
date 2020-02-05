package com.cristianvillamil.platziwallet.ui.observable

interface Observer {
    fun notifyChange(newValue: Double)
}