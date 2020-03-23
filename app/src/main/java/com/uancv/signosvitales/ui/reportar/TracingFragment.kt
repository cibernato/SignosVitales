package com.uancv.signosvitales.ui.reportar


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.uancv.signosvitales.R
import com.uancv.signosvitales.ui.reportar.graficos.RespFragment
import com.uancv.signosvitales.ui.reportar.graficos.TempFragment
import com.uancv.signosvitales.utils.log
import kotlinx.android.synthetic.main.fragment_tracing.*
import lecho.lib.hellocharts.model.*


/**
 * A simple [Fragment] subclass.
 */
class TracingFragment : Fragment() {
    var axisData = arrayOf(
        "Jan",
        "Feb",
        "Mar",
        "Apr",
        "May",
        "June",
        "July",
        "Aug",
        "Sept",
        "Oct",
        "Nov",
        "Dec"
    )
    var yAxisData = intArrayOf(50, 20, 15, 30, 20, 60, 15, 40, 45, 10, 65, 18)
    var yAxisValues = arrayListOf<PointValue>()
    var data2 = arrayListOf<PointValue>()
    var axisValues = arrayListOf<AxisValue>()

    lateinit var botones :ArrayList<View?>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentManager!!.beginTransaction().add(R.id.chart, TempFragment()).addToBackStack("")
            .commit()
        botones = arrayListOf()
        return inflater.inflate(R.layout.fragment_tracing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        botones.add(temp_button)
        botones.add(resp_button)
        botones.add(latidos_button)
        botones.add(presion_button)
        super.onViewCreated(view, savedInstanceState)
        cambiarFondoDeView(temp_button)
        generarGraficoLineas(2)
        temp_button.setOnClickListener {
            fragmentManager!!.popBackStack()
            fragmentManager!!.beginTransaction().replace(R.id.chart, TempFragment()).commit()
            cambiarFondoDeView(it)
        }
        resp_button.setOnClickListener {
            fragmentManager!!.popBackStack()
            fragmentManager!!.beginTransaction().replace(R.id.chart, RespFragment()).commit()
            cambiarFondoDeView(it)
        }
        latidos_button.setOnClickListener {
            cambiarFondoDeView(it)
            log("${it.isEnabled}")
        }
    }

    private fun cambiarFondoDeView(it: View?) {
        botones.forEach {view ->
            view?.isEnabled = view != it
        }

    }


    private fun generarGraficoLineas(r: Int) {

//        chart.lineChartData.lines = arrayListOf<Line>()
        val line = Line(yAxisValues).setColor(Color.GREEN)
        axisData.forEachIndexed { index, s ->
            axisValues.add(AxisValue(index.toFloat()).setLabel(s))
        }
        yAxisData.forEachIndexed { index, i ->
            yAxisValues.add(PointValue(index.toFloat(), i.toFloat()))
        }
        val line2 = Line(data2).setColor(Color.YELLOW)
        for (i in 0..10) {
            data2.add(PointValue(i.toFloat(), (i * r).toFloat()))
        }
        val lines = arrayListOf<Line>().apply { add(line) }
        lines.add(line2)
        val data = LineChartData().setLines(lines)
        val yAxis = Axis()
        val axis = Axis()
        axis.values = axisValues
        data.axisXBottom = axis
        data.axisYLeft = yAxis
        axis.textSize = 14
        axis.textColor = Color.BLUE
        yAxis.textSize = 14
        yAxis.textColor = Color.BLUE
        yAxis.name = "Vamos bien"

//        chart.lineChartData = data
    }


}
