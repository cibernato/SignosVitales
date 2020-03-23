package com.uancv.signosvitales.utils

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

//const val api = BuildConfig.api_prueba

fun Fragment.toast(message: String) {
    Toast.makeText(context!!, message, Toast.LENGTH_LONG).show()
}

fun Context.log(message: String) {
    Log.e(this.javaClass.simpleName, message)
}

fun Fragment.log(message: String) {
    Log.e(this.javaClass.simpleName, message)
}

fun View.getWidthDividedBy(ratio: Int): Int {
    val displaymetrics = DisplayMetrics()
    (this.context as Activity).windowManager.defaultDisplay.getMetrics(displaymetrics)
    return displaymetrics.widthPixels / ratio
}

fun View.getHeightDividedBy(ratio: Int): Int {
    val displaymetrics = DisplayMetrics()
    (this.context as Activity).windowManager.defaultDisplay.getMetrics(displaymetrics)
    return displaymetrics.heightPixels / ratio
}

fun View.setWidthAndHeightOfView(id: Int, width: Int, height: Int) {
    this.findViewById<View>(id).layoutParams.width = width
    this.findViewById<View>(id).layoutParams.height = height
}