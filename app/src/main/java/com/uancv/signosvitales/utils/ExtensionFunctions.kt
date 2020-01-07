package com.uancv.signosvitales.utils

import android.content.Context
import android.util.Log
import android.widget.Toast

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Context.log(message: String) {
    Log.e(this.javaClass.simpleName, message)
}