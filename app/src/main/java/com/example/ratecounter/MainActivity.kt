package com.example.ratecounter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeact:Button = findViewById(R.id.time_activity_btn)
        timeact.setOnClickListener{
            val intent = Intent(this, TimeActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

//        For Calculating using MM or Meter
        val cutting_mm = findViewById<EditText>(R.id.cutting_mm)
        val cutting_rate = findViewById<EditText>(R.id.cutting_rate)
        val cutting_total = findViewById<EditText>(R.id.cutting_total)

        val travel_mm = findViewById<EditText>(R.id.travel_mm)
        val travel_rate = findViewById<EditText>(R.id.travel_rate)
        val travel_total = findViewById<EditText>(R.id.travel_total)

        val total_mm = findViewById<EditText>(R.id.total_mm)
        val total_all = findViewById<EditText>(R.id.all_total)


        val done_btn_mm = findViewById<Button>(R.id.donebtnmm)
        val clear_btn_mm = findViewById<Button>(R.id.clearbtnmm)

        done_btn_mm.setOnClickListener {

            var cutmeter: Float = (cutting_mm.text.toString()).toFloat() / 1000
            var cutrate: Float = (cutting_rate.text.toString()).toFloat()
            var cuttotal: Float = cutmeter * cutrate
            cutting_total.setText(cuttotal.toString())

            var travmeter: Float = (travel_mm.text.toString()).toFloat() / 1000
            var travrate: Float = (travel_rate.text.toString()).toFloat()
            var travtotal: Float = travmeter * travrate
            travel_total.setText(travtotal.toString())

            total_mm.setText((cutmeter * 1000 + travmeter * 1000).toString())
            total_all.setText((cuttotal + travtotal).toString())
        }

        clear_btn_mm.setOnClickListener {
            cutting_mm.setText("")
            cutting_rate.setText("")
            cutting_total.setText("")
            travel_mm.setText("")
            travel_rate.setText("")
            travel_total.setText("")
            total_mm.setText("")
            total_all.setText("")
        }

////        For calculating using Time
//
//        val cutting_hour = findViewById<EditText>(R.id.cutting_hour)
//        val cutting_min = findViewById<EditText>(R.id.cutting_min)
//        val cutting_sec = findViewById<EditText>(R.id.cutting_sec)
//
//        val travel_hour = findViewById<EditText>(R.id.travel_hour)
//        val travel_min = findViewById<EditText>(R.id.travel_min)
//        val travel_sec = findViewById<EditText>(R.id.travel_sec)
//
//        val total_minute = findViewById<EditText>(R.id.total_minute)
//        val total_rate_min = findViewById<EditText>(R.id.total_rate_min)
//
//        val total_cut_rate = findViewById<TextView>(R.id.cutting_total_rate)
//        val total_trav_rate = findViewById<TextView>(R.id.travel_total_rate)
//
//        val done_btn_time = findViewById<Button>(R.id.donebtntime)
//        val clear_btn_time = findViewById<Button>(R.id.clearbtntime)
//
//        done_btn_time.setOnClickListener {
//            Toast.makeText(this, "inside", Toast.LENGTH_LONG).show()
//            val rate = findViewById<EditText>(R.id.cutting_hour_rate).toString().toFloat()
//
//            var cuthour: Float = (cutting_hour.text.toString()).toFloat() * 60
//            var cutmin: Float = (cutting_min.text.toString()).toFloat()
//            var cutsec: Float = (cutting_sec.text.toString()).toFloat() / 60
//            var cuttotal: Float = (cuthour + cutmin + cutsec)
//            var cutrate: Float = cuttotal * (rate / 60)
//            total_cut_rate.setText(cuttotal.toString())
//
//            var travhour: Float = (travel_mm.text.toString()).toFloat() * 60
//            var travmin: Float = (travel_rate.text.toString()).toFloat()
//            var travsec: Float = (travel_rate.text.toString()).toFloat() / 60
//            var travtotal: Float = (travhour + travmin + travsec)
//            var travrate: Float = travtotal * (rate / 60)
//            total_trav_rate.setText(travtotal.toString())
//
//            total_minute.setText(cuttotal.toString())
//            total_rate_min.setText((cutrate + travrate).toString())
//        }
//
//        clear_btn_time.setOnClickListener {
//            cutting_hour.setText("")
//            cutting_min.setText("")
//            cutting_sec.setText("")
//            travel_hour.setText("")
//            travel_min.setText("")
//            travel_sec.setText("")
//            total_minute.setText("")
//            total_rate_min.setText("")
//            total_trav_rate.text = ""
//            total_cut_rate.text = ""
//        }
    }
}