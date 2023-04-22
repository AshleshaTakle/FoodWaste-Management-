package com.example.food_waste_managment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class noncoufood : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noncoufood)

        val edfood = findViewById<EditText>(R.id.edfood)
        val btn = findViewById<Button>(R.id.btnsend)

        val sharedpreferences = getSharedPreferences("farmer", MODE_PRIVATE)
        val add = sharedpreferences!!.getString("email", "deafult")
        Toast.makeText(applicationContext,add.toString(), Toast.LENGTH_LONG).show()

        btn.setOnClickListener {

            val msg = edfood.text.toString().trim()
            val s = send(applicationContext,add.toString(),"Request",msg)
            s.execute()
        }

    }
}