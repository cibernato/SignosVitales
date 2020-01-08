package com.uancv.signosvitales.ui.reportar


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.uancv.signosvitales.R
import com.uancv.signosvitales.utils.getWidthDividedBy
import com.uancv.signosvitales.utils.setWidthAndHeightOfView

/**
 * A simple [Fragment] subclass.
 */
class ConstantesVitalesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_constantes_vitales, container, false)
        val width = view.getWidthDividedBy(3)
        view.findViewById<TextInputLayout>(R.id.temperatura_edit_layout).layoutParams.width = width*2
        val heightIcon = view.findViewById<TextInputLayout>(R.id.temperatura_edit_layout).layoutParams.height
        view.findViewById<TextInputLayout>(R.id.presion_edit_layout).layoutParams.width = width*2
        view.findViewById<TextInputLayout>(R.id.pulso_edit_layout).layoutParams.width = width*2
        view.findViewById<TextInputLayout>(R.id.respiracion_edit_layout).layoutParams.width = width*2
        view.setWidthAndHeightOfView(R.id.temperatura_icon,heightIcon,heightIcon)
        view.setWidthAndHeightOfView(R.id.presion_icon,heightIcon,heightIcon)
        view.setWidthAndHeightOfView(R.id.pulso_icon,heightIcon,heightIcon)
        view.setWidthAndHeightOfView(R.id.respiracion_icon,heightIcon,heightIcon)
        return view
    }


}
