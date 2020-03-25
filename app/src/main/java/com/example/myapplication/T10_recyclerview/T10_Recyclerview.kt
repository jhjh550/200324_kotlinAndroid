package com.example.myapplication.T10_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t10__recyclerview.*


class T10_Recyclerview : AppCompatActivity() {
    data class MyData(val title:String, val desc:String, val img:Int)
    val myList = ArrayList<MyData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t10__recyclerview)

        generateData()
        myRecyclerView.adapter = MyRecyclerViewAdapter(myList)
        myRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun generateData(){
        val icons = arrayOf(R.drawable.ic_control_point_black_24dp,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher_round)
        for(i in 0..100){
            val icon = icons[i%3]
            myList.add(MyData("title $i", "desc $i", icon))
        }
    }

}
