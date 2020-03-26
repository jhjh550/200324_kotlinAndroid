package com.example.myapplication.P01_weather

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_p01__weathrer.*
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.net.URL

class P01_Weathrer : AppCompatActivity() {

    data class MyWeatherData(val hour:Int, var day:Int,
                             var temp:Float, var wfKor:String)
    val myWeatherList = ArrayList<MyWeatherData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p01__weathrer)
        WeatherTask().execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1153052000")
    }
    fun initRecyclerView(){
        weatherRecyclerView.adapter = MyWeatherRecyclerViewAdapter(myWeatherList)
        weatherRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    inner class WeatherTask: AsyncTask<String, Unit, String>(){
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            initRecyclerView()
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
