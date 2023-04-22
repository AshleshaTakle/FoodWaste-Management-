package com.example.food_waste_managment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class disproduct : AppCompatActivity() {

    private var database: FirebaseDatabase? = null
    private var ref: DatabaseReference? = null

    private var adapter:PAdapter?=null
    private var list: ArrayList<order>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disproduct)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(LinearLayoutManager(this))

        list = ArrayList()

        val pref = getSharedPreferences("farmer", MODE_PRIVATE)
        val name = pref.getString("name", "No name defined")
        Toast.makeText(applicationContext,name.toString(), Toast.LENGTH_LONG).show()
        database = FirebaseDatabase.getInstance()
        ref = database!!.getReference("data")

        val mDatabaseRef = FirebaseDatabase.getInstance().getReference("order")

        val query: Query = mDatabaseRef.orderByChild("farmername").equalTo(name)

        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                print(dataSnapshot)


                for (data in dataSnapshot.children) {
                    println(data)




                    val models: order? = data.getValue(order::class.java)
                    println(models)
                    if (models != null) {
                        list!!.add(models)
                    }

                }

                adapter = PAdapter(list,applicationContext)
                recyclerView.adapter = adapter

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })



    }
}