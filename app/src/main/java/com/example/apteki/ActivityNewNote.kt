package com.example.apteki

import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TimePicker
import com.ibotta.android.support.pickerdialogs.SupportedTimePickerDialog
import kotlinx.android.synthetic.main.activity_new_note.*
import kotlinx.android.synthetic.main.toolbarformenu.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.timer


lateinit var mDataSetListener:DatePickerDialog.OnDateSetListener
class ActivityNewNote : AppCompatActivity(),SupportedTimePickerDialog.OnTimeSetListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)
        setSupportActionBar(toolbarformenu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        showDatePicker()
    }

    private fun loadState(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            currentDate = savedInstanceState.getSerializable(CURRENT_DATE_KEY) as Calendar
        }
    }
        fun showDatePicker() {
            // DatePicker

          text_sana.setText(SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()))

            var cal = Calendar.getInstance()

            val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val myFormat = "dd/MM/yyyy" // mention the format you need
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                text_sana.setText(sdf.format(cal.time))
            }

            btn_sana.setOnClickListener {

                Log.d("Clicked", "Interview Date Clicked")

                val dialog = DatePickerDialog(this, dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH))
               // dialog.datePicker.maxDate = DatePickerDialog.getCurrentDateInMills()
                dialog.show()
            }
            btn_vaqt.setOnClickListener {
                val hour = currentDate.get(Calendar.HOUR_OF_DAY)
                val minute = currentDate.get(Calendar.MINUTE)
                SupportedTimePickerDialog(
                    context = this,
                    themeResId =  R.style.SpinnerTimePickerDialogTheme,
                    timeSetListener = this,
                    mInitialHourOfDay = hour,
                    mInitialMinute = minute,
                    mIs24HourView = true)
                    .show()
            }
        }
    private fun setTime() {
        //text_vaqt.setText.toString())
       // setDateOrTime(R.string.time_format, R.string.time_picker_row_title, timer())
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        currentDate.set(Calendar.HOUR_OF_DAY, hourOfDay)
        currentDate.set(Calendar.MINUTE, minute)
        setTime()
    }
    companion object {
        private var currentDate = Calendar.getInstance()
        private const val CURRENT_DATE_KEY = "currentDate"
    }
}