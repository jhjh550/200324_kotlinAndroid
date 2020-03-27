package com.example.myapplication.T18_service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t18_service.*

class T18_service : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t18_service)

        btnStart.setOnClickListener {
            val myIntent = Intent(
                this, MyService::class.java)
            startService(myIntent)
        }
        btnStop.setOnClickListener {
            val myIntent = Intent(
                this, MyService::class.java)
            stopService(myIntent)
        }
    }
}
