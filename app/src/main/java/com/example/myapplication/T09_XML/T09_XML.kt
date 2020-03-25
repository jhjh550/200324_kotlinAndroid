package com.example.myapplication.T09_XML

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t09__x_m_l.*
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.net.URL

// http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1153052000

class T09_XML : AppCompatActivity() {

    data class MyWeatherData(val hour:Int, var day:Int,
                             var temp:Float, var wfKor:String)
    val myWeatherList = ArrayList<MyWeatherData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t09__x_m_l)

        WeatherTask().execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1153052000")
    }

    fun initListView(){
        weatherListView.adapter = MyWeatherAdapter()
    }

    inner class MyWeatherAdapter: BaseAdapter(){
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var v = convertView
            if(v == null) {
                v = LayoutInflater.from(parent?.context)
                    .inflate(R.layout.item_custom_listview, parent, false)
            }
            val data = myWeatherList[position]

            val tvTitle: TextView = v!!.findViewById(R.id.tvTitle)
            val tvDesc: TextView = v.findViewById(R.id.tvDesc)
            val itemImageView: ImageView = v.findViewById(R.id.itemImageView)

            tvTitle.text = "${data.day} ${data.hour}시"
            tvDesc.text = "${data.wfKor} ${data.temp}'c"
            //itemImageView.setImageResource(data.img)

            return v
        }

        override fun getItem(position: Int): Any {
            return myWeatherList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return myWeatherList.size
        }

    }

    inner class WeatherTask:AsyncTask<String, Unit, String>(){
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            initListView()
        }

        override fun doInBackground(vararg params: String?): String {
            val path = params[0]!!
            val url = URL(path)

            val factory = XmlPullParserFactory.newInstance()
            val xpp = factory.newPullParser()
            xpp.setInput(url.openStream(), "utf-8")

            var res = ""
            var eventType = xpp.eventType
            var startTag = ""
            var data = MyWeatherData(0,0,0.0f,"")
            while (eventType != XmlPullParser.END_DOCUMENT){
                if(eventType == XmlPullParser.START_TAG){
                    startTag = xpp.name
                }else if(eventType == XmlPullParser.TEXT){
                    when(startTag){
                        "hour"->{
                            val hour = xpp.text.toInt()
                            data = MyWeatherData(hour,0,0.0f,"")
                            myWeatherList.add(data)
                        }
                        "day"->{ data.day = xpp.text.toInt() }
                        "wfKor"->{ data.wfKor = xpp.text }
                        "temp"->{ data.temp = xpp.text.toFloat() }
                    }
                    startTag=""
                }
                eventType = xpp.next()
            }
            return res
        }
    }
}
