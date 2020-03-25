package com.example.myapplication.T09_XML

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
// http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1153052000

class T09_XML : AppCompatActivity() {

    data class MyWeatherData(val hour:Int, val day:Int,
                             val temp:Float, val wfKor:String)
    val myWeatherList = ArrayList<MyWeatherData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t09__x_m_l)

        WeatherTask().execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1153052000")
    }

    inner class WeatherTask:AsyncTask<String, Unit, String>(){
        override fun doInBackground(vararg params: String?): String {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}
