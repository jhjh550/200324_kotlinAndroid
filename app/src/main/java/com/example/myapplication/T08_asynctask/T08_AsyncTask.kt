package com.example.myapplication.T08_asynctask

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t08__async_task.*

class T08_AsyncTask : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t08__async_task)

        btnAsyncTask.setOnClickListener {
            val task = MyTask()
            task.execute(30)
        }
    }

    inner class MyTask: AsyncTask<Int, Float, String>(){
        override fun doInBackground(vararg params: Int?): String {
            params[0]
        }

    }
}
