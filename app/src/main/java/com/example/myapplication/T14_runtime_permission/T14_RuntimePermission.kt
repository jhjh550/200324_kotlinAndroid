package com.example.myapplication.T14_runtime_permission

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_t14__runtime_permission.*

class T14_RuntimePermission : AppCompatActivity() {

    private val REQCODE_PERMISSION = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t14__runtime_permission)

        btnPermission.setOnClickListener {
            val permission = ContextCompat.checkSelfPermission(
                this, READ_EXTERNAL_STORAGE)
            if(permission == PackageManager.PERMISSION_GRANTED){
                listFiles()
            }else{
                setupPermission()
            }
        }
    }

    fun listFiles(){

    }

    fun setupPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(
                this, READ_EXTERNAL_STORAGE
            )){
            AlertDialog.Builder(this)
                .setTitle("Permission request!!")
                .setMessage("읽기 권한이 필요합니다.")
                .setPositiveButton("OK"){ dialogInterface, which ->
                    requestReadPermission()
                }
                .show()
        }else{
            requestReadPermission()
        }
    }
    fun requestReadPermission(){
        ActivityCompat.requestPermissions(this,
            arrayOf(READ_EXTERNAL_STORAGE), REQCODE_PERMISSION)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == REQCODE_PERMISSION){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                listFiles()
            }
        }
    }
}




