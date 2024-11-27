package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity7 : AppCompatActivity() {

    //declare to connect with database
    private lateinit var dbRef : DatabaseReference

    //initial all component
    private lateinit var smfeedback : Button
    private lateinit var rsfeedback : Button
    private lateinit var nameee : EditText
    private lateinit var id : EditText
    private lateinit var give : EditText
    private lateinit var backfeedback : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)


        //declare all component
        smfeedback = findViewById(R.id.submitFeedback)
        rsfeedback = findViewById(R.id.resetFeedback)
        nameee = findViewById(R.id.nameFb)
        id = findViewById(R.id.idFb)
        give = findViewById(R.id.giveFb)
        backfeedback = findViewById(R.id.backfb)

        //popup message when click button add record
        Toast.makeText(this, " ", Toast.LENGTH_LONG).show()

        smfeedback.setOnClickListener {
            //call function save Data
            //parameter - input data string
            saveData(
                give.text.toString(),
                nameee.text.toString(),
                id.text.toString()
            )
        }

        rsfeedback.setOnClickListener {
            nameee.setText(" ")
            id.setText(" ")
            give.setText(" ")
        }

        backfeedback.setOnClickListener {
            val i = Intent (this, MainActivity3::class.java)
            startActivity(i)
        }
    }
    private fun saveData(f:String, w:String, l:String) {

        //link database named customer
        dbRef = FirebaseDatabase.getInstance().getReference("Feedback")

        val personfb = dbRef.push().key!!

        val em = Model3(f, personfb, w, l)

        dbRef.child(personfb).setValue(em)

            .addOnCompleteListener {
                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failure", Toast.LENGTH_LONG).show()
            }
    }
}