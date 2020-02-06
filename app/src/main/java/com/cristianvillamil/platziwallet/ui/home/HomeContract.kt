package com.cristianvillamil.platziwallet.ui.home

import androidx.lifecycle.LiveData

interface HomeContract {

    interface View{
        fun showLoader()
        fun hideLoader()
        fun showFavoriteTransfers(favoriteTransfer: List<FavoriteTransfer>)
    }

    interface Presenter{
        fun retrieveFavoriteTransfers()
        fun getPercentageLiveData() : LiveData<String>
    }

    interface OnResponseCallback{
        fun onResponse(favoriteList : List<FavoriteTransfer>)
    }
}