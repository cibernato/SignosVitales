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
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val v = LayoutInflater.from(activity)
            .inflate(R.layout.fragment_date_picker, null)
        val datePicker = v.findViewById<DatePicker>(R.id.dialog_date_date_picker)
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

}
