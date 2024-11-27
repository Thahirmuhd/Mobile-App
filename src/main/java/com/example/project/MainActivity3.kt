package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity3 : AppCompatActivity() {

    private lateinit var vehicle : ImageButton
    private lateinit var about : ImageButton
    private lateinit var contact : ImageButton
    private lateinit var feedback : ImageButton
    private lateinit var backkk : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        vehicle = findViewById(R.id.btnOne)
        about = findViewById(R.id.btnAbout)
        contact = findViewById(R.id.btnContact)
        feedback = findViewById(R.id.btnFeedback)
        backkk = findViewById(R.id.bckinfo)

        vehicle.setOnClickListener {
            val i = Intent (this, MainActivity4::class.java)
            startActivity(i)
        }

        about.setOnClickListener {
            val i = Intent (this, MainActivity5::class.java)
            startActivity(i)
        }

        contact.setOnClickListener {
            val i = Intent (this, MainActivity6::class.java)
            startActivity(i)
        }

        feedback.setOnClickListener {
            val i = Intent (this, MainActivity7::class.java)
            startActivity(i)
        }

        backkk.setOnClickListener {
            val i = Intent (this, MainActivity::class.java)
            startActivity(i)
        }
    }
}