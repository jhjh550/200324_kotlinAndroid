package com.example.myapplication.T15_sharedPreperences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.R

class T15_SharedPreferences : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t15__shared_preferences)

        val pref = getSharedPreferences("mySettings", 0)
        val name = pref.getString("name", "")
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        val pref = getSharedPreferences("mySettings", 0)
        val editor = pref.edit()
        editor.putString("name", "hello")
        editor.apply()
    }
}
