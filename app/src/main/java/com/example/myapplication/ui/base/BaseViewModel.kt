package com.example.myapplication.ui.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import java.lang.ref.WeakReference

open class BaseViewModel<N>(application: Application?) : AndroidViewModel(application!!) {
    private lateinit var mNavigator: WeakReference<N>
    lateinit var context: Context
    val navigator: N
        get() = mNavigator.get()!!

    fun setNavigator(mNavigator: N) {
        this.mNavigator = WeakReference(mNavigator)
    }

    fun attachContext(context: Context) {
        this.context = context
    }


}