package com.example.myapplication.T02_UIWidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t02__u_i_widget.*

class T02_UIWidgetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t02__u_i_widget)

        btnMyButton.setOnClickListener {
            Toast.makeText(this, "hello button", Toast.LENGTH_SHORT).show()
        }
        myCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            Toast.makeText(this, "checked $isChecked", Toast.LENGTH_SHORT).show()
        }
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioButton1 -> {
                    Toast.makeText(this, "radio1 selected", Toast.LENGTH_SHORT).show()
                }
                R.id.radioButton2 -> {
                    Toast.makeText(this, "radio2 selected", Toast.LENGTH_SHORT).show()
                }
                R.id.radioButton3 -> {
                    Toast.makeText(this, "radio3 selected", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
