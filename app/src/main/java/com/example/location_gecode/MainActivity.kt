package com.example.location_gecode

import android.content.pm.PackageManager
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.app.ActivityCompat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var  ed :EditText
    lateinit var  btn : Button
    lateinit var  tv : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed = findViewById(R.id.editTextTextPersonName)
        btn = findViewById(R.id.button)
        tv = findViewById(R.id.textView2)

        if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION,android.Manifest.permission.ACCESS_FINE_LOCATION),111)
            }else{
                btn.setOnClickListener {
                  var city = ed.text.toString()
                    forwardGeoLocation(city)
                }
            }
         }
    private fun forwardGeoLocation(city:String){
        var gc = Geocoder(this, Locale.getDefault())
        var address = gc.getFromLocationName(city,2)
        var ad = address.get(0)
        tv.setText(ad.toString())
       // tv.setText("${ad.longitude}\n${ad.longitude}\n${ad.longitude}")
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 111 &&grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {

            }
        }
    }

