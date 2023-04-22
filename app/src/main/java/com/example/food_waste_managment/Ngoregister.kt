package com.example.food_waste_managment

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Ngoregister : AppCompatActivity() {

    val MY_PREFS_NAME = "MyPrefsFile"

    lateinit var auth: FirebaseAuth

    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null

    var add:String?=null

    var sharedpreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ngoregister)


        val name = findViewById<EditText>(R.id.student_name)

        val address = findViewById<EditText>(R.id.student_address)
        val number = findViewById<EditText>(R.id.student_monumber)
        val email = findViewById<EditText>(R.id.student_email)
        val password = findViewById<EditText>(R.id.student_password)
        val btn = findViewById<Button>(R.id.btnregister)
        auth = FirebaseAuth.getInstance()

        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("Ngo")



        btn.setOnClickListener {
            if(name.text.isEmpty())
            {
                name.setError("Enter name")
                return@setOnClickListener
            }else if(password.text.isEmpty())
            {
                password.setError("Enter Password ")
                return@setOnClickListener
            }else if(number.text.isEmpty())
            {
                number.setError("Enter Contact Number")
                return@setOnClickListener
            }else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches())
            {
                email.setError("Enter Email id")
                return@setOnClickListener
            }

            add=address.text.toString()

            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful)
                    {
                        val currentuser = auth.currentUser
                        val currentUserdb = databaseReference?.child((currentuser?.uid!!))
                        currentUserdb?.child("name")?.setValue(name.text.toString())

                        currentUserdb?.child("Address")?.setValue(address.text.toString())

                        currentUserdb?.child("number")?.setValue(number.text.toString())

                        Toast.makeText(applicationContext,"Registration Successfull", Toast.LENGTH_LONG).show()
                        val editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit()
                        editor.putString("mail",email.text.toString())
                        editor.apply()

                        editor.commit()
//                        Toast.makeText(applicationContext,adhar.text.toString(), Toast.LENGTH_LONG).show()


                    }
                    else
                    {
                        Toast.makeText(applicationContext,"Registration Failed", Toast.LENGTH_LONG).show()
                    }
                }
            sharedata(name.text.toString(),email.text.toString(),address.text.toString())

        }

    }

    private fun sharedata(name: String, email: String, add: String) {

        sharedpreferences = getSharedPreferences("Myaddress", MODE_PRIVATE)
        val editor = sharedpreferences!!.edit()

        editor.putString("ngoadd", add)
        editor.putString("email",email)

        editor.commit()
        editor.apply()

    }


}