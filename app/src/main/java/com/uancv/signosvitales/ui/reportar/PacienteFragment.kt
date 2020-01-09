package com.uancv.signosvitales.ui.reportar


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.viewModelScope
import com.uancv.signosvitales.R
import com.uancv.signosvitales.activities.SharedViewModel
import com.uancv.signosvitales.models.RefreshToken
import com.uancv.signosvitales.ui.dialogs.DatePickerFragment
import com.uancv.signosvitales.utils.ApiService
import com.uancv.signosvitales.utils.log
import kotlinx.android.synthetic.main.fragment_paciente.*
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 */
class PacienteFragment : Fragment() {

    lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        log("se crea el fragment")
        activity?.let {
            sharedViewModel = ViewModelProviders.of(it).get(SharedViewModel::class.java)
        }
        return inflater.inflate(R.layout.fragment_paciente, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val COUNTRIES = arrayOf("Hombre", "Mujer")
        val adapter = ArrayAdapter(
            context!!,
            R.layout.dropdown_menu_popup_item,
            COUNTRIES
        )
        filled_exposed_dropdown.setAdapter(adapter)
        fecha_nacimiento_paciente.setOnClickListener {
            generarDialog()
        }
        fecha_nacimiento_paciente.editText?.setOnClickListener {
            generarDialog()
        }
        button.setOnClickListener {
            pruebaRetrofit()
        }

    }

    private fun pruebaRetrofit() {

        sharedViewModel.viewModelScope.launch {
            ApiService.service.searchArtist(
                RefreshToken(
                    "UOp5su9wEZTF3tjbqyND0X23iYuxyxtJl292e7DpJLSsVeI3yab441Gd7Qxpulnr0qSlRtHLniXqUf3NntuwAtcGLfYbP5g3WgTcOQ6VLoQ=",
                    "eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNyc2Etc2hhMjU2Iiwia2lkIjoiNjYwMzczMkUzMjI3QzA3QkU4RDBBQkQ0NzJGMzg1MEE4RjM0NEVGRCIsInR5cCI6IkpXVCIsIng1YyI6WyJtc3NlZ3VyaWRhZCIsInJzaWxsb2NhLWdpdCJdfQ.eyJuYmYiOjE1Nzg1OTA2MjksImV4cCI6MTU3ODU5MDY4OSwiaXNzIjoibXNzZWd1cmlkYWQiLCJhdWQiOiI1M2U3NzM2Y2YzYTM0NjI0YjRlNjRmNjkyODc3MmQwNCIsInNjb3BlcyI6eyJJZEludml0YWRvIjoxMDU5MTgsIkRvY3VtZW50b0ludml0YWRvIjoiNzU3OTc3OTkiLCJJZFVzdWFyaW8iOjI4LCJVc3VhcmlvIjoicnNpbGxvY2EtZ2l0IiwiVGlwb1Rva2VuIjowLCJJZEVudGlkYWRQZXJzb25hIjoxMDU5MTgsIklkRW50aWRhZEVtcHJlc2EiOjEwMDE1LCJEb2N1bWVudG9FbXByZXNhIjoiMjA0NTUxMTQ1NjEiLCJEb2N1bWVudG9QZXJzb25hIjoiNzU3OTc3OTkiLCJTdWN1cnNhbGVzIjpbXSwiU2VydmljaW9zIjpbXX19.WvsxU8KXjjD48N_SAFsH4miDPZgg2nJUcyUuFQm_VHgyfBmx__cCwcTrdP3rM0eBETABwV0TGTVWyoUYjcB9tTjUQlXKB5kFApjaSHplV-nk2OJmvhzMSffQ1UwTf25QpaDaazxQX96J8Iyu3L-3RmdkaD-wc7LLtJxMcxqPhfxPPDmt8t1WP9l5SIYRgR5q7eue8QzQ6PQTPLfIrV5rzwKuZMKKk7NWRgaD1_6YswQEJLkwVJhe73wHvADSAQmigAZ1WlFrvsKhBE65tVXCnxpBzObKGozrxP010k4JIE_qsiTlRp2ZTPR5G3dGOr_j9DPXwmb4I-5QHcCNS7bhMg",
                    27
                )
            ).enqueue(object : Callback<RefreshToken?> {
                override fun onFailure(call: Call<RefreshToken?>, t: Throwable) {
                    log("${t.printStackTrace()}")
                }

                override fun onResponse(
                    call: Call<RefreshToken?>,
                    response: Response<RefreshToken?>
                ) {
                    if (response.code() == 200) {
                        log(response.body().toString())
                        log(response.body()!!.AccessToken!!)
                    } else {
                        log(response.errorBody()!!.string())
                        log("${response.raw().headers()}")
                    }
                }
            })

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            159 -> {
                fecha_nacimiento_paciente.editText?.setText(data?.getStringExtra("date") ?: "null")
            }
        }
    }

    fun generarDialog() {
        val d =
            DatePickerFragment.newInstace(if (fecha_nacimiento_paciente.editText?.text.toString().isNotEmpty()) fecha_nacimiento_paciente.editText?.text.toString() else "")
        d.setTargetFragment(this, 159)
        d.show(fragmentManager!!, "")
    }


}
