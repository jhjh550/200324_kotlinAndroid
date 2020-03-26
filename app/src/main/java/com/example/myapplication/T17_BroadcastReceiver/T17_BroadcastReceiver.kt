package com.example.myapplication.T17_BroadcastReceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t17__broadcast_receiver.*
val MY_EVENT = "hello.world.kotlin.android"
fun helloworld(){

}
class T17_BroadcastReceiver : AppCompatActivity() {

    lateinit var receiver: MyReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t17__broadcast_receiver)

        btnSend.setOnClickListener {
            val myIntent = Intent()
            myIntent.action = MY_EVENT
            sendBroadcast(myIntent)
        }
        receiver = MyReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction(MY_EVENT)
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED)
        registerReceiver(receiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}
