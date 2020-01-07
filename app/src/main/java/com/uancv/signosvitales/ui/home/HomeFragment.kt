package com.uancv.signosvitales.ui.home

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.uancv.signosvitales.R
import com.uancv.signosvitales.activities.SharedViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(SharedViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val dis = DisplayMetrics()
        activity!!.windowManager.defaultDisplay.getMetrics(dis)
        val height = dis.heightPixels / 6
        val width = dis.widthPixels / 6
        root.findViewById<ImageView>(R.id.agregar_icon).layoutParams.height = height
        root.findViewById<ImageView>(R.id.agregar_icon).layoutParams.width = width
        root.findViewById<ImageView>(R.id.ayuda_icon).layoutParams.height = height
        root.findViewById<ImageView>(R.id.ayuda_icon).layoutParams.width = width
        root.findViewById<ImageView>(R.id.graficos_icon).layoutParams.height = height
        root.findViewById<ImageView>(R.id.graficos_icon).layoutParams.width = width
        root.findViewById<ImageView>(R.id.pacientes_icon).layoutParams.height = height
        root.findViewById<ImageView>(R.id.pacientes_icon).layoutParams.width = width
        root.findViewById<ImageView>(R.id.usuarios_icon).layoutParams.height = height
        root.findViewById<ImageView>(R.id.usuarios_icon).layoutParams.width = width
        root.findViewById<ImageView>(R.id.reportar_icon).layoutParams.height = height
        root.findViewById<ImageView>(R.id.reportar_icon).layoutParams.width = width
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        reportar_icon.setOnClickListener {
            findNavController().navigate(R.id.navigation_reportarViewPager)
        }
        reportar_text.setOnClickListener {

        }
    }


}