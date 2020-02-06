package com.cristianvillamil.platziwallet.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.cristianvillamil.platziwallet.R

class PercentageView : FrameLayout{

    constructor(context: Context, attrs: AttributeSet, defStyle : Int) : super(
        context,
        attrs,
        defStyle
    ){
        initView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        initView()
    }

    constructor(context: Context) : super(context){
        initView()
    }

    private fun initView(){
        val view = View.inflate(context, R.layout.percentage_view, null)
        addView(view)
    }
}