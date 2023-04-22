package com.example.food_waste_managment

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class hoteldash : AppCompatActivity() {

    var sharedpreferences: SharedPreferences? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_hoteldash)

        val track = findViewById<Button>(R.id.track)
        val addfood =  findViewById<Button>(R.id.addfood)
        val logout = findViewById<Button>(R.id.logout)


        track.setOnClickListener()
        {
            sharedpreferences = getSharedPreferences("Myaddress", MODE_PRIVATE)
            val add = sharedpreferences!!.getString("ngoadd", "")
            Toast.makeText(applicationContext,"NGO Address "+add.toString(),Toast.LENGTH_LONG).show()
//            val add = "katraj"

//                sharedpreferences = getSharedPreferences("My", MODE_PRIVATE)
//                val useradd = sharedpreferences!!.getString("address", "")
//            val useradd="akrudi"

            try {
                val uri = Uri.parse("https://www.google.co.in/maps/dir/"+"/"+ add)

                val intent = Intent(Intent.ACTION_VIEW,uri)
                intent.setPackage("com.google.android.apps.maps")
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)

            }catch (e: ActivityNotFoundException)
            {
                val uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps")
                val intent = Intent(Intent.ACTION_VIEW,uri)
                intent.setPackage("com.google.android.apps.maps")
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }

        addfood.setOnClickListener()
        {
            val intent = Intent(applicationContext,Addhotelfood::class.java)
            startActivity(intent)
        }

        logout.setOnClickListener(){
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }





}
