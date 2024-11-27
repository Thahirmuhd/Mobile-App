package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    private lateinit var btnRes : Button
    private lateinit var btnLog : Button
    private lateinit var email : EditText
    private lateinit var password : EditText
    private lateinit var faq : ImageButton
    private lateinit var manual : ImageButton

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRes = findViewById(R.id.btnRegister)
        btnLog = findViewById(R.id.btnLogIn)
        email = findViewById(R.id.emailLogIn)
        password = findViewById(R.id.passwordLogIn)
        faq = findViewById(R.id.btnFaq)
        manual = findViewById(R.id.btnManual)

        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.reference.child("Customer")

        faq.setOnClickListener {
            val i = Intent (this, MainActivity8::class.java)
            startActivity(i)
        }

        btnRes.setOnClickListener {
            val i = Intent(this, MainActivity2::class.java)
            startActivity(i)
        }

        manual.setOnClickListener {
            val i = Intent(this, MainActivity9::class.java)
            startActivity(i)
        }

        btnLog.setOnClickListener {

            val email = email.text.toString()
            val password = password.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                logIn(email, password)
            } else {
                Toast.makeText(this@MainActivity, "All fields are mandatory", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun logIn(email:String, password:String){
        databaseReference.orderByChild("customerEmail").equalTo(email).addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()){
                    for (custSnapshot in dataSnapshot.children){
                        val model = custSnapshot.getValue(Model::class.java)

                        if (model != null && model.customerPassword == password){
                            Toast.makeText(this@MainActivity, "Login Succesful", Toast.LENGTH_LONG).show()
                            startActivity(Intent(this@MainActivity, MainActivity3::class.java))
                            finish()
                            return
                        }
                    }
                }
                Toast.makeText(this@MainActivity, "Input did not matched", Toast.LENGTH_LONG).show()
            }
            override fun onCancelled(databaseError: DatabaseError){
                Toast.makeText(this@MainActivity, "Database Error: ${databaseError.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}