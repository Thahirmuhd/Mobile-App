package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity2 : AppCompatActivity() {

    //declare to connect with database
    private lateinit var dbRef : DatabaseReference

    //initial all component
    private lateinit var submit : Button
    private lateinit var reset : Button
    private lateinit var name : EditText
    private lateinit var password : EditText
    private lateinit var phone : EditText
    private lateinit var email : EditText
    private lateinit var backreg : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //declare all component
        submit = findViewById(R.id.btnSubmit)
        reset = findViewById(R.id.btnReset)
        name = findViewById(R.id.eTName)
        password = findViewById(R.id.eTPassword)
        phone = findViewById(R.id.eTPhone)
        email = findViewById(R.id.eTEmail)
        backreg = findViewById(R.id.bck)

        //popup message when click button add record
        Toast.makeText(this, " ", Toast.LENGTH_LONG).show()

        submit.setOnClickListener {
            //call function save Data
            //parameter - input data string
            saveData(
                email.text.toString(),
                name.text.toString(),
                password.text.toString(),
                phone.text.toString()

            )
        }

        reset.setOnClickListener {
            name.setText(" ")
            password.setText(" ")
            phone.setText(" ")
            email.setText(" ")
        }

        backreg.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }

    private fun saveData(e:String, n:String, p:String, t:String) {

        //link database named customer
        dbRef = FirebaseDatabase.getInstance().getReference("Customer")

        val custId = dbRef.push().key!!

        val em = Model(e, custId, n, p, t)

        dbRef.child(custId).setValue(em)

            .addOnCompleteListener {
                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failure", Toast.LENGTH_LONG).show()
            }

        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}