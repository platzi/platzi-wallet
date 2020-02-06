package com.cristianvillamil.platziwallet.ui.loans

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoansViewModel :  ViewModel() {

    private val percentageLiveData : MutableLiveData<String> = MutableLiveData()
    private val loansListLiveData : MutableLiveData<List<Loan>> = MutableLiveData()

    fun changeValues(){
        percentageLiveData.value = "100%"
        loansListLiveData.value = emptyList()
    }

    fun getPercentageLiveData() : LiveData<String> = percentageLiveData

    fun getLoansListLiveData() : LiveData<List<Loan>> = loansListLiveData

    override fun onCleared() {
        super.onCleared()
    }
}