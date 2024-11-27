package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity4 : AppCompatActivity() {

    //declare to connect with database
    private lateinit var dbRef : DatabaseReference

    //initial all component
    private lateinit var regveh : Button
    private lateinit var resetveh : Button
    private lateinit var namee : EditText
    private lateinit var ic : EditText
    private lateinit var plat : EditText
    private lateinit var blok : EditText
    private lateinit var backkkk : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        //declare all component
        regveh = findViewById(R.id.btnVeh)
        resetveh = findViewById(R.id.resetVeh)
        namee = findViewById(R.id.inputName)
        ic = findViewById(R.id.inputic)
        plat = findViewById(R.id.inputPlat)
        blok = findViewById(R.id.inputBlok)
        backkkk = findViewById(R.id.backreg)

        //popup message when click button add record
        Toast.makeText(this, " ", Toast.LENGTH_LONG).show()

        regveh.setOnClickListener {
            //call function save Data
            //parameter - input data string
            saveData(
                blok.text.toString(),
                namee.text.toString(),
                ic.text.toString(),
                plat.text.toString()

            )
        }

        resetveh.setOnClickListener {
            namee.setText(" ")
            ic.setText(" ")
            plat.setText(" ")
            blok.setText(" ")
        }

        backkkk.setOnClickListener {
            val i = Intent (this, MainActivity3::class.java)
            startActivity(i)
        }

    }

    private fun saveData(em:String, na:String, pa:String, ph:String) {

        //link database named customer
        dbRef = FirebaseDatabase.getInstance().getReference("Person")

        val personId = dbRef.push().key!!

        val em = Modele(em, personId, na, pa, ph)

        dbRef.child(personId).setValue(em)

            .addOnCompleteListener {
                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failure", Toast.LENGTH_LONG).show()
            }


    }
}