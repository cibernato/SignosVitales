package com.uancv.signosvitales.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.uancv.signosvitales.ui.reportar.ConstantesVitalesFragment
import com.uancv.signosvitales.ui.reportar.PacienteFragment
import com.uancv.signosvitales.ui.reportar.TracingFragment

class ViewPagerReportarAdapter(
    fm: FragmentManager
) : FragmentPagerAdapter(fm, BEHAVIOR_SET_USER_VISIBLE_HINT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> PacienteFragment()
            1 -> ConstantesVitalesFragment()
            else -> TracingFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

}