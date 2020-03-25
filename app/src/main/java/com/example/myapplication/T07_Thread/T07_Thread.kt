package com.example.myapplication.T07_Thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t07__thread.*

class T07_Thread : AppCompatActivity() {

    private val MY_COUNT = 100
    val myHandler = object : Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if(msg.what == MY_COUNT){
                btnThread.text = "count ${msg.arg1}"
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t07__thread)

        btnThread.setOnClickListener {
            Thread{
                for(i in 0..100){
                    //Log.d("Thrad", "count $i")
                    //btnThread.text = "count $i"
                    Thread.sleep(100)
                    val msg = myHandler.obtainMessage()
                    msg.what = MY_COUNT
                    msg.arg1 = i
                    myHandler.sendMessage(msg)
                }
            }.start()
        }
    }
}
