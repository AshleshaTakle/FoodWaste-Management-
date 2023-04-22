package com.example.food_waste_managment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class productdetails : AppCompatActivity() {

    var farmername: String? = null
    var productname: String? = null
    var description: String? = null

    var ref: DatabaseReference? = null
    var username: String? = null
    var usermobile: String? = null
    var useremail: String? = null
    var useraddress: String? = null
    var url: String? = null
    val MY_PREFS_NAME = "MyPrefsFile"


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productdetails)

        val edusername = findViewById<EditText>(R.id.edname)
        val ednumber = findViewById<EditText>(R.id.ednumber)
        val  edaddress = findViewById<EditText>(R.id.edaddress)
        val btn = findViewById<Button>(R.id.btnorder)


        btn.setOnClickListener {

            val bundle = intent.extras


            farmername = bundle?.getString("fname")
            productname = bundle?.getString("pname")
            description = bundle?.getString("des")
//            Toast.makeText(applicationContext,farmername,Toast.LENGTH_LONG).show()



            val sb = StringBuffer()
            sb.append("username").append(edusername.text.toString().trim())
            sb.append(System.getProperty("line.separator"))
            sb.append("Number").append(ednumber.text.toString())
            sb.append(System.getProperty("line.separator"))
            sb.append("Address").append(edaddress.text.toString())
            sb.append(System.getProperty("line.separator"))
            val msg = sb.toString()
//            Toast.makeText(applicationContext,msg,Toast.LENGTH_LONG).show()

            val pref = getSharedPreferences("farmer", MODE_PRIVATE)
            val email = pref.getString("email", "No name defined")
            val sen = send(applicationContext,email.toString()," Order ",msg)
            sen.execute()

            storedata(farmername,edusername.text.toString(),edaddress.text.toString(),ednumber.text.toString())

            val sharedpreferences = getSharedPreferences("My", MODE_PRIVATE)
            val editor = sharedpreferences!!.edit()

            editor.putString("name", farmername)


            editor.commit()
            editor.apply()
        }





    }

    private fun storedata(farmername: String?, name: String, address: String, number: String) {

        val data = FirebaseDatabase.getInstance().getReference().child("order")
        val user = order(name,number,address,farmername)
        data.push().setValue(user)


    }
}