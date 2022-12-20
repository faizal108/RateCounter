package com.example.ratecounter

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TimeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        val mmact:Button = findViewById(R.id.mm_activity_btn)
        mmact.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

        Toast.makeText(this,"new activity",Toast.LENGTH_LONG).show()

        //        For calculating using Time

        val cutting_hour = findViewById<EditText>(R.id.cutting_hour)
        val cutting_min = findViewById<EditText>(R.id.cutting_min)
        val cutting_sec = findViewById<EditText>(R.id.cutting_sec)

        val travel_hour = findViewById<EditText>(R.id.travel_hour)
        val travel_min = findViewById<EditText>(R.id.travel_min)
        val travel_sec = findViewById<EditText>(R.id.travel_sec)

        val total_minute = findViewById<EditText>(R.id.total_minute)
        val total_rate_min = findViewById<EditText>(R.id.total_rate_min)

        val total_cut_rate = findViewById<TextView>(R.id.cutting_total_rate)
        val total_trav_rate = findViewById<TextView>(R.id.travel_total_rate)

        val done_btn_time = findViewById<Button>(R.id.donebtntime)
        val clear_btn_time = findViewById<Button>(R.id.clearbtntime)

        done_btn_time.setOnClickListener {
            Toast.makeText(this, "inside", Toast.LENGTH_LONG).show()
            val rate = findViewById<EditText>(R.id.cutting_hour_rate).toString().toFloat()

            val cuthour: Float = (cutting_hour.text.toString()).toFloat() * 60
            val cutmin: Float = (cutting_min.text.toString()).toFloat()
            val cutsec: Float = (cutting_sec.text.toString()).toFloat() / 60
            val cuttotal: Float = (cuthour + cutmin + cutsec)
            val cutrate: Float = cuttotal * (rate / 60)
            total_cut_rate.setText(cuttotal.toString())

            var travhour: Float = (travel_hour.text.toString()).toFloat() * 60
            var travmin: Float = (travel_min.text.toString()).toFloat()
            var travsec: Float = (travel_sec.text.toString()).toFloat() / 60
            var travtotal: Float = (travhour + travmin + travsec)
            var travrate: Float = travtotal * (rate / 60)
            total_trav_rate.setText(travtotal.toString())

            total_minute.setText(cuttotal.toString())
            total_rate_min.setText((cutrate + travrate).toString())
        }

        clear_btn_time.setOnClickListener {
            cutting_hour.setText("")
            cutting_min.setText("")
            cutting_sec.setText("")
            travel_hour.setText("")
            travel_min.setText("")
            travel_sec.setText("")
            total_minute.setText("")
            total_rate_min.setText("")
            total_trav_rate.text = ""
            total_cut_rate.text = ""
        }
    }
}