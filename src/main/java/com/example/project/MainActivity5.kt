package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity5 : AppCompatActivity() {

    private lateinit var backabout : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        backabout = findViewById(R.id.backAbout)

        backabout.setOnClickListener {
            val i = Intent (this, MainActivity3::class.java)
            startActivity(i)
        }
    }
}