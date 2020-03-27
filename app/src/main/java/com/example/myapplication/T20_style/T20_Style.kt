package com.example.myapplication.T20_style

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t20__style.*

class T20_Style : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t20__style)

        val numberListener = View.OnClickListener {
            val btn = it as Button
            val value = btn.text.toString()
            val working = tvWorking.text.toString()
            if(working == "0"){
                tvWorking.text = value
            }else{
                tvWorking.text = "${working}${value}"
            }
        }

        btnOne.setOnClickListener(numberListener)
        btnZero.setOnClickListener(numberListener)
        btnEnter.setOnClickListener {
            tvSelected.text = tvWorking.text
            tvWorking.text = "0"
        }
    }
}
