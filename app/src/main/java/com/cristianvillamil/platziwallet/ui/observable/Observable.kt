package com.cristianvillamil.platziwallet.ui.observable

interface Observable {
    fun addObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers(newValue: Double)
}