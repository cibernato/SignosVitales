package com.uancv.signosvitales.ui.reportar


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.uancv.signosvitales.R
import com.uancv.signosvitales.adapters.ViewPagerReportarAdapter
import kotlinx.android.synthetic.main.fragment_reportar_view_pager.*

class ReportarViewPager : Fragment() {

    lateinit var reportarViewModel: ReportarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        reportarViewModel = ViewModelProviders.of(this).get(ReportarViewModel::class.java)
        return inflater.inflate(R.layout.fragment_reportar_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ViewPagerReportarAdapter(fragmentManager!!, context!!)
        reportar_view_pager.offscreenPageLimit = 3
        reportar_view_pager.adapter = adapter
        publicaciones_tab_layout.setupWithViewPager(reportar_view_pager)

    }
}
