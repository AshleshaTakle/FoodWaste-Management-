package com.example.food_waste_managment

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class userdash : AppCompatActivity() {

    var sharedpreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userdash)


        val btnadd = findViewById<Button>(R.id.btnadd)

        btnadd.setOnClickListener {
            val intent = Intent(applicationContext,showproduct::class.java)
            startActivity(intent)

        }










    }
}