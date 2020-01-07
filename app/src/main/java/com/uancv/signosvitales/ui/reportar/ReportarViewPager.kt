package com.uancv.signosvitales.ui.reportar


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.uancv.signosvitales.R
import com.uancv.signosvitales.adapters.ViewPagerReportarAdapter
import kotlinx.android.synthetic.main.fragment_reportar_view_pager.*

/**
 * A simple [Fragment] subclass.
 */
class ReportarViewPager : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reportar_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ViewPagerReportarAdapter(childFragmentManager)
        reportar_view_pager.adapter = adapter
        publicaciones_tab_layout.setupWithViewPager(reportar_view_pager)
        publicaciones_tab_layout.getTabAt(0)?.text = "Pacientes"
        publicaciones_tab_layout.getTabAt(1)?.text = "Constantes"
        publicaciones_tab_layout.getTabAt(2)?.text = "Tracing"
    }
}
