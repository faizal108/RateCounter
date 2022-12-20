package com.example.ratecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TableLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radio_mm = findViewById<RadioButton>(R.id.mm_radio)
        val radio_time = findViewById<RadioButton>(R.id.time_radio)

        val mm_table = findViewById<TableLayout>(R.id.mm_table)
        val time_table = findViewById<TableLayout>(R.id.time_table)

        radio_mm.setOnCheckedChangeListener { buttonView, isChecked ->
//            Toast.makeText(this,"millimeter",Toast.LENGTH_SHORT).show()
            if(isChecked.toString() == "true"){
                mm_table.visibility = View.VISIBLE
                time_table.visibility = View.GONE
            }else{
                mm_table.visibility = View.GONE
                time_table.visibility = View.VISIBLE
            }
        }
        radio_time.setOnCheckedChangeListener { buttonView, isChecked ->
//            Toast.makeText(this,"time",Toast.LENGTH_SHORT).show()
            if(isChecked.toString() == "true"){
                time_table.visibility = View.VISIBLE
                mm_table.visibility = View.GONE
            }else{
                time_table.visibility = View.GONE
                mm_table.visibility = View.VISIBLE
            }
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
        val clear_btn_time = findViewById<Button>(R.id.clearbtnmm)

        done_btn_mm.setOnClickListener{

            var cutmeter:Float = (cutting_mm.text.toString()).toFloat() / 1000
            var cutrate:Float = (cutting_rate.text.toString()).toFloat()
            var cuttotal:Float = cutmeter * cutrate
            cutting_total.setText(cuttotal.toString())

            var travmeter:Float = (travel_mm.text.toString()).toFloat() / 1000
            var travrate:Float = (travel_rate.text.toString()).toFloat()
            var travtotal:Float = travmeter * travrate
            travel_total.setText(travtotal.toString())

            total_mm.setText((cutmeter*1000 + travmeter*1000).toString())
            total_all.setText((cuttotal+travtotal).toString())
        }

        clear_btn_time.setOnClickListener{
            cutting_mm.setText("")
            cutting_rate.setText("")
            cutting_total.setText("")
            travel_mm.setText("")
            travel_rate.setText("")
            travel_total.setText("")
            total_mm.setText("")
            total_all.setText("")
        }
    }
}