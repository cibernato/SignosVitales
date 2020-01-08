package com.uancv.signosvitales.ui.dialogs


import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.uancv.signosvitales.R


/**
 * A simple [Fragment] subclass.
 */
class TimePickerFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_picker, container, false)
    }

    interface TimeDialogListener {
        fun onFinishDialog(time: String)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val v = LayoutInflater.from(activity)
            .inflate(R.layout.fragment_time_picker, null)

        var timePicker = v.findViewById(R.id.dialog_time_picker) as TimePicker
        return AlertDialog.Builder(activity)
            .setView(v)
            .setTitle("Seleccione una hora")
            .setPositiveButton(
                android.R.string.ok
            ) { _, _ ->
                val hour: Int =
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        timePicker.hour
                    } else {
                        timePicker.currentHour
                    }
                val minute: Int =
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        timePicker.minute
                    } else {
                        timePicker.currentMinute
                    }
                sendResult(updateTime(hour, minute))
                dismiss()
            }
            .create()
    }

    private fun sendResult(time: String) {
        val intent = Intent().apply {
            putExtra("time", time)
        }
        targetFragment?.onActivityResult(targetRequestCode, 123, intent)
    }

    private fun updateTime(hours: Int, mins: Int): String {
        var hours = hours

        val timeSet: String
        when {
            hours > 12 -> {
                hours -= 12
                timeSet = "PM"
            }
            hours == 0 -> {
                hours += 12
                timeSet = "AM"
            }
            hours == 12 -> timeSet = "PM"
            else -> timeSet = "AM"
        }

        val minutes: String = if (mins < 10)
            "0$mins"
        else
            mins.toString()

        return StringBuilder().append(hours).append(':')
            .append(minutes).append(" ").append(timeSet).toString()
    }

}
