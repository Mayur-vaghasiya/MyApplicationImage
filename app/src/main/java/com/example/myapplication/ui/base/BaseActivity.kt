package com.example.myapplication.ui.base

import android.app.ProgressDialog
import android.content.BroadcastReceiver
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel<*>?> : AppCompatActivity() {
    private lateinit var viewDataBinding: T
    private var mViewModel: V? = null
    private var mProgressDialog: ProgressDialog? = null
    private lateinit var loggedOutUserReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()

    }

    abstract fun setHeader()
    abstract val bindingVariable: Int

    @get:LayoutRes
    abstract val layoutId: Int
    abstract val viewModel: V
    abstract fun setObservers()


    fun getViewDataBinding(): T {
        return viewDataBinding
    }

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        mViewModel = if (mViewModel == null) viewModel else mViewModel
        viewDataBinding?.setVariable(bindingVariable, mViewModel)
        viewDataBinding?.executePendingBindings()
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()

    }

}