package com.uancv.signosvitales.activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uancv.signosvitales.R

class SharedViewModel : ViewModel() {

    private var _fechaConstantes = MutableLiveData<Any>().apply { value = R.string.presione_aqui }

    val fechaConstantes: LiveData<Any>
        get() = _fechaConstantes

    private var _horaConstantes = MutableLiveData<Any>().apply { value = R.string.presione_aqui }

    val horaConstantes: LiveData<Any>
        get() = _horaConstantes

    fun postFechaConstantes(fecha: String) = _fechaConstantes.postValue(fecha)

    fun postHoraConstantes(s: String) = _horaConstantes.postValue(s)


}