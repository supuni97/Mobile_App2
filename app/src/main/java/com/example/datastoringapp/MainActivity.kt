package com.example.datastoringapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("SP_INFO",Context.MODE_PRIVATE)

        saveBtn.setOnClickListener{

            val str = stringEt.text.toString().trim()
            val swt = switch1.isChecked

            val editor=sharedPreferences.edit()

            editor.putString("String",str)
            editor.putBoolean("Boolean_value",swt)
            editor.apply()
        }

        showDataBtn.setOnClickListener{

            val str = sharedPreferences.getString("String","")
            val switch1 = sharedPreferences.getBoolean("Boolean_value",false)

            InfoTv.text="String : $str \nBoolean value : $switch1"

        }



    }
}