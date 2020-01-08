package com.uancv.signosvitales.ui.reportar


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputLayout
import com.uancv.signosvitales.R
import com.uancv.signosvitales.ui.dialogs.DatePickerFragment
import com.uancv.signosvitales.ui.dialogs.TimePickerFragment
import com.uancv.signosvitales.utils.getWidthDividedBy
import com.uancv.signosvitales.utils.setWidthAndHeightOfView
import com.uancv.signosvitales.utils.toast
import kotlinx.android.synthetic.main.fragment_constantes_vitales.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class ConstantesVitalesFragment : Fragment() {

    lateinit var reportarViewModel: ReportarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_constantes_vitales, container, false)
        inicializarVistas(view)
        reportarViewModel =
            ViewModelProviders.of(parentFragment!!).get(ReportarViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fecha_text.setOnClickListener {
            val d = DatePickerFragment()
            d.setTargetFragment(this, 159)
            d.show(fragmentManager!!, "")
        }
        hora_text.setOnClickListener {
            val d = TimePickerFragment()
            d.setTargetFragment(this, 123)
            d.show(fragmentManager!!, "")
        }
        reportarViewModel.fechaConstantes.observe(this, androidx.lifecycle.Observer {
            fecha_text.text = if (it is Int) getString(it) else it.toString()
        })
        reportarViewModel.horaConstantes.observe(this, androidx.lifecycle.Observer {
            hora_text.text = if (it is Int) getString(it) else it.toString()
        })
        guardar_button.setOnClickListener {
            try {
                val res = context!!.resources
                val dm = res.displayMetrics
                val conf = res.configuration
                var language = if (conf.locale.language == "en") "es" else "en"
                conf.setLocale(Locale(language))
                res.updateConfiguration(conf, dm)
                activity?.recreate()
            } catch (e: Exception) {
                toast("$e + ${e.printStackTrace()}")
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            123 -> {
                reportarViewModel.postHoraConstantes(data?.getStringExtra("time") ?: "nulo 123 ")
            }
            159 -> {
                reportarViewModel.postFechaConstantes(data!!.getStringExtra("date") ?: "nulo 159")
            }
        }
    }

    private fun inicializarVistas(view: View) {
        val width = view.getWidthDividedBy(3)
        view.findViewById<TextInputLayout>(R.id.temperatura_edit_layout).layoutParams.width =
            width * 2
        val heightIcon =
            view.findViewById<TextInputLayout>(R.id.temperatura_edit_layout).layoutParams.height
        view.findViewById<TextInputLayout>(R.id.presion_edit_layout).layoutParams.width = width * 2
        view.findViewById<TextInputLayout>(R.id.pulso_edit_layout).layoutParams.width = width * 2
        view.findViewById<TextInputLayout>(R.id.respiracion_edit_layout).layoutParams.width =
            width * 2
        view.setWidthAndHeightOfView(R.id.temperatura_icon, heightIcon, heightIcon)
        view.setWidthAndHeightOfView(R.id.presion_icon, heightIcon, heightIcon)
        view.setWidthAndHeightOfView(R.id.pulso_icon, heightIcon, heightIcon)
        view.setWidthAndHeightOfView(R.id.respiracion_icon, heightIcon, heightIcon)
    }


}
