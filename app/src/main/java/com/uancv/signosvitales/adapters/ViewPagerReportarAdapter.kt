package com.uancv.signosvitales.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.uancv.signosvitales.R
import com.uancv.signosvitales.ui.reportar.ConstantesVitalesFragment
import com.uancv.signosvitales.ui.reportar.PacienteFragment
import com.uancv.signosvitales.ui.reportar.TracingFragment

class ViewPagerReportarAdapter(
    fm: FragmentManager,
    context: Context
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val fragments = arrayListOf(
        PacienteFragment(),
        ConstantesVitalesFragment(),
        TracingFragment()
    )

    private val nombres = arrayListOf(
        context.getString(R.string.pacientes),
        context.getString(R.string.constantes),
        context.getString(R.string.graficas)
    )

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return nombres[position]
    }


}