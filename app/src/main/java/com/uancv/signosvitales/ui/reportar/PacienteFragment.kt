package com.uancv.signosvitales.ui.reportar


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.uancv.signosvitales.R
import com.uancv.signosvitales.utils.log
import kotlinx.android.synthetic.main.fragment_paciente.*


/**
 * A simple [Fragment] subclass.
 */
class PacienteFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        log("se crea el fragment")
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
    }


}
