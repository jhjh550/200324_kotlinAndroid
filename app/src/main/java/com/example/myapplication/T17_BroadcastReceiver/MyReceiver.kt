package com.example.myapplication.T17_BroadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action){
            Intent.ACTION_POWER_CONNECTED -> {
                Toast.makeText(context, "MyReceiver power connected ",
                    Toast.LENGTH_LONG).show()
            }
            Intent.ACTION_BOOT_COMPLETED ->{
                Toast.makeText(context, "MyReceiver boot completed",
                    Toast.LENGTH_LONG).show()
            }
            Intent.ACTION_BATTERY_CHANGED->{
                val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
            }
        }

    }
}
