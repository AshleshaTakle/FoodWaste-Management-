package com.example.food_waste_managment

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.app.PendingIntent
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
import androidx.core.app.NotificationCompat

class ngodash : AppCompatActivity() {

    var sharedpreferences: SharedPreferences? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ngodash)

        val track = findViewById<Button>(R.id.track)
        val check = findViewById<Button>(R.id.check)
        val delivery = findViewById<Button>(R.id.delivery)
        val logout = findViewById<Button>(R.id.logout)

        track.setOnClickListener()
        {

                sharedpreferences = getSharedPreferences("My", MODE_PRIVATE)
                val useradd = sharedpreferences!!.getString("address", "")

                try {
                    val uri = Uri.parse("https://www.google.co.in/maps/dir/"+"/"+ useradd)

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

        check.setOnClickListener()
        {
            val intent= Intent(applicationContext,displaydata::class.java)
            startActivity(intent)
        }

        delivery.setOnClickListener()
        {
            sendnotification()
        }

        logout.setOnClickListener()
        {
            val intent = Intent(applicationContext,Ngologin::class.java)
            startActivity(intent)
        }

    }

    private fun sendnotification() {
        Toast.makeText(applicationContext,"Delivery Successfull",Toast.LENGTH_LONG).show()
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.item, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//
//        when(item.itemId)
//        {
//            R.id.add->{
//
//                sharedpreferences = getSharedPreferences("My", MODE_PRIVATE)
//                val useradd = sharedpreferences!!.getString("address", "")
//
//                try {
//                    val uri = Uri.parse("https://www.google.co.in/maps/dir/"+"/"+ useradd)
//
//                    val intent = Intent(Intent.ACTION_VIEW,uri)
//                    intent.setPackage("com.google.android.apps.maps")
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                    startActivity(intent)
//
//                }catch (e: ActivityNotFoundException)
//                {
//                    val uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps")
//                    val intent = Intent(Intent.ACTION_VIEW,uri)
//                    intent.setPackage("com.google.android.apps.maps")
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                    startActivity(intent)
//                }
//
//            }
//        R.id.phistory->{
//            val intent = Intent(applicationContext,displaydata::class.java)
//            startActivity(intent)
//        }
//        R.id.delivery->{
//            sendnotification()
//        }
//
//        R.id.logout->{
//            val intent = Intent(applicationContext,logout::class.java)
//            startActivity(intent)
//        }
//    }
//        return super.onOptionsItemSelected(item)
//    }
//
//    private fun sendnotification() {
//        Toast.makeText(applicationContext,"Delivery Successfully",Toast.LENGTH_LONG).show()
//    }
}