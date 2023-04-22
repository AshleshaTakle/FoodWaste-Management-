package com.example.food_waste_managment

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class farmerdash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farmerdash)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.farmerlist, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.add->{
                val intent = Intent(applicationContext,product::class.java)
                startActivity(intent)


            }
            R.id.phistory->{
                val intent = Intent(applicationContext,disproduct::class.java)
                startActivity(intent)
            }
            R.id.delivery->{
               Toast.makeText(applicationContext,"Request Sent To Bio Gas Plant",Toast.LENGTH_LONG).show()
            }

            R.id.logout->{
                val intent = Intent(applicationContext,MainActivity::class.java)
                startActivity(intent)
            }
        }




        return super.onOptionsItemSelected(item)
    }
}