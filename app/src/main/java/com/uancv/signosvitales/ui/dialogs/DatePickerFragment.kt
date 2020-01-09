package com.uancv.signosvitales.ui.dialogs


import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.uancv.signosvitales.R
import java.text.SimpleDateFormat
import java.util.*


class DatePickerFragment : DialogFragment() {

    var dateString: String? = null
    private lateinit var datePicker: DatePicker

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val v = LayoutInflater.from(activity)
            .inflate(R.layout.fragment_date_picker, null)
        datePicker = v.findViewById(R.id.dialog_date_date_picker)
        if (dateString != "") {
            val fields = dateString!!.split("/")
            datePicker.updateDate(fields[2].toInt(), fields[1].toInt(), fields[0].toInt())
        }
        return AlertDialog.Builder(activity)
            .setView(v)
            .setTitle("Select date")
            .setPositiveButton(
                android.R.string.ok
            ) { _, _ ->
                val year = datePicker.year
                val mon = datePicker.month
                val day = datePicker.dayOfMonth
                val date = GregorianCalendar(year, mon, day).time
                sendResults(date)
                dismiss()
            }
            .create()
    }

    fun sendResults(date: Date) {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val intent = Intent().apply {
            putExtra("date", sdf.format(date))
        }
        targetFragment?.onActivityResult(targetRequestCode, 159, intent)
    }


    companion object {
        fun newInstace(date: String): DatePickerFragment {
            return DatePickerFragment().apply {
                dateString = date
            }
        }
    }

}
