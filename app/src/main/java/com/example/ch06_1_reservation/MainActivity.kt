package com.example.ch06_1_reservation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity()
{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "시간 예약"

//        var year1 = 0
//        var month1 = 0
//        var day1 = 0

        // 버튼
//        var btnStart = findViewById<Button>(R.id.btnStart)
//        var btnEnd = findViewById<Button>(R.id.btnEnd)

        // 크로노미터
        var chrono = findViewById<Chronometer>(R.id.chronometer1)

        // 라디오버튼 2개
        var rdoCal = findViewById<RadioButton>(R.id.rdoCal)
        var rdoTime = findViewById<RadioButton>(R.id.rdoTime)

        // FrameLayout의 2개 위젯
        var tPicker = findViewById<TimePicker>(R.id.timePicker1)
//        var calView = findViewById<CalendarView>(R.id.calendarView1)
        var dPicker = findViewById<DatePicker>(R.id.dPicker1)

        // 텍스트뷰 중에서 연,월,일,시,분 숫자
        var tvYear = findViewById<TextView>(R.id.tvYear)
        var tvMonth = findViewById<TextView>(R.id.tvMonth)
        var tvDay = findViewById<TextView>(R.id.tvDay)

        var tvHour = findViewById<TextView>(R.id.tvHour)
        var tvMinute = findViewById<TextView>(R.id.tvMinute)

        tPicker.visibility = View.INVISIBLE
//        calView.visibility = View.INVISIBLE
        dPicker.visibility = View.INVISIBLE

        rdoCal.visibility = View.INVISIBLE
        rdoTime.visibility = View.INVISIBLE



        rdoCal.setOnClickListener {
            tPicker.visibility = View.INVISIBLE
//            calView.visibility = View.VISIBLE
            dPicker.visibility = View.VISIBLE
        }

        rdoTime.setOnClickListener {
            tPicker.visibility = View.VISIBLE
//            calView.visibility = View.INVISIBLE
            dPicker.visibility = View.INVISIBLE
        }

//        btnStart.setOnClickListener {
//            chrono.base = SystemClock.elapsedRealtime()
//            chrono.start()
//            chrono.setTextColor(Color.RED)
//        }

        chrono.setOnClickListener {
            chrono.base = SystemClock.elapsedRealtime()
            chrono.start()
            chrono.setTextColor(Color.RED)

            rdoCal.visibility = View.VISIBLE
            rdoTime.visibility = View.VISIBLE
        }

//        btnEnd.setOnClickListener {
//
//            chrono.stop()
//            chrono.setTextColor(Color.BLUE)
//
//            //결과 텍스트뷰에 1.날짜(년,월,일) 과 2.시간(시,분)
//
//            tvYear.setText(year1.toString())
//            tvMonth.setText(month1.toString())
//            tvDay.setText(day1.toString())
//
//
//            var hour1 = tPicker.currentHour.toString()
//            tvHour.setText(hour1)
//            tvMinute.setText(tPicker.currentMinute.toString())
//
//        }

        tvYear.setOnLongClickListener {
            chrono.stop()
            chrono.setTextColor(Color.BLUE)

            //결과 텍스트뷰에 1.날짜(년,월,일) 과 2.시간(시,분)

            //캘린더 뷰 일때 방법
//            tvYear.setText(year1.toString())
//            tvMonth.setText(month1.toString())
//            tvDay.setText(day1.toString())

            tvYear.setText(dPicker.year.toString())
            tvMonth.setText((dPicker.month + 1).toString())
            tvDay.setText(dPicker.dayOfMonth.toString())

            var hour1 = tPicker.currentHour.toString()
            tvHour.setText(hour1)
            tvMinute.setText(tPicker.currentMinute.toString())

            rdoCal.visibility = View.INVISIBLE
            rdoTime.visibility = View.INVISIBLE
            dPicker.visibility = View.INVISIBLE
            tPicker.visibility = View.INVISIBLE

            false
        }


//        calView.setOnDateChangeListener { view, year, month, dayOfMonth ->
//
//            year1 = year
//            month1 = month + 1
//            day1 = dayOfMonth
//
//
//        }



    }
}