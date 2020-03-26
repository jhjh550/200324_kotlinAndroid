package com.example.myapplication.T16_SQLite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R

class T16_SQLite : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t16__s_q_lite)

        val myHandler = MyDBHandler(this)
        myHandler.insert("kim", 10, "seoul")
        myHandler.insert("가나다", 11, "부산")
        myHandler.insert("hello", 12, "world")

        myHandler.delete("hello")
        myHandler.update("가나다", 13)

        val res = myHandler.selectAll()
        Log.d("db", res)
    }
}
