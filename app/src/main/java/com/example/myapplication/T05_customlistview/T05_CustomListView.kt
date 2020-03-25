package com.example.myapplication.T05_customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t05__custom_list_view.*

class T05_CustomListView : AppCompatActivity() {
    data class MyData(val title:String, val desc:String, val img:Int)
    val myList = ArrayList<MyData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t05__custom_list_view)
        generateData()
        customListView
    }

    fun generateData(){
        val icons = arrayOf(R.drawable.ic_control_point_black_24dp,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher_round)
        for(i in 0..100){
            val icon = icons[i%3]
            myList.add(MyData("title $i", "desc $i", icon))
        }
    }

    inner class MyCustomAdapter: BaseAdapter(){
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val v = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_custom_listview, parent, false)

        }

        override fun getItem(position: Int): Any {
            return myList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return myList.size
        }

    }
}
