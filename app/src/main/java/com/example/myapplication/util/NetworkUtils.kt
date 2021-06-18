package com.example.myapplication.util

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager

object NetworkUtils {
    @JvmStatic
    fun isNetworkConnected(context: Context?): Boolean {
        return isInternetAvailable(context)
    }

    @SuppressLint("MissingPermission")
    private fun isInternetAvailable(context: Context?): Boolean {
        return if (context != null) {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!.isConnectedOrConnecting
        } else {
            false
        }
    }
}