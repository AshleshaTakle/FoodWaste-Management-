package com.example.food_waste_managment

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.SharedPreferences
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class Adduserdata : AppCompatActivity() {
    val MY_PREFS_NAME = "MyPrefsFile"

    var sharedpreferences: SharedPreferences? = null

    var chapati:String?=null
    var dal:String?=null
    var sabji:String?=null
    var conaddress:String?=null
    var time:String?=null
    var name:String?=null
    var number:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adduserdata)


        sharedpreferences = getSharedPreferences("My", MODE_PRIVATE)

       name = sharedpreferences!!.getString("name","")
         number = sharedpreferences!!.getString("number","")
        Toast.makeText(applicationContext,name,Toast.LENGTH_LONG).show()


        val edchapati = findViewById<EditText>(R.id.edchapati)
        val eddal = findViewById<EditText>(R.id.eddal)
        val edbhaji = findViewById<EditText>(R.id.edsabji)
        val edaddress = findViewById<EditText>(R.id.edaddress)
        val edexpiry = findViewById<EditText>(R.id.edtime)



        val btn = findViewById<Button>(R.id.btnsubmit)

        btn.setOnClickListener {

             chapati = edchapati.text.toString()
             dal = eddal.text.toString()
             sabji = edbhaji.text.toString()

             conaddress = edaddress.text.toString()
            time=edexpiry.text.toString()

            val geocode = Geocoder(this, Locale.getDefault())

            val addlist = geocode.getFromLocationName(conaddress,1)
            val lat = addlist[0].latitude.toString()
            val lng = addlist[0].longitude.toString()


            val data = FirebaseDatabase.getInstance().getReference().child("UserFood")
            val user = Userfood("hotelname",chapati,dal,sabji,lat,lng,time,"Active")
            data.push().setValue(user)
                sharedata(conaddress!!)
            Toast.makeText(applicationContext,"Uploaded",Toast.LENGTH_LONG).show()
                sendnotify()
        }



    }

    private fun sendnotify() {

        val sb = StringBuffer()
        sb.append("name").append(name)
        sb.append(System.getProperty("line.separator"))
        sb.append("Mobile no").append(number)
        sb.append(System.getProperty("line.separator"))
        sb.append("Dal").append(dal)
        sb.append(System.getProperty("line.separator"))
        sb.append("sabji").append(sabji)
        sb.append(System.getProperty("line.separator"))
        sb.append("chapati").append(chapati)
        sb.append(System.getProperty("line.separator"))
        sb.append("Address").append(conaddress)
        sb.append(System.getProperty("line.separator"))
        sb.append("time").append(time)
        val msg = sb.toString()

        val prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE)
        val mail = prefs.getString("mail", "No name defined")
        val se = send(applicationContext,mail.toString(),"Place Order Successfully",msg)
        se.execute()

    }
    private fun sharedata(conaddress: String) {
        sharedpreferences = getSharedPreferences("Myaddress", MODE_PRIVATE)
        val editor = sharedpreferences!!.edit()

        editor.putString("useradd", conaddress)

        editor.commit()
        editor.apply()

    }
}