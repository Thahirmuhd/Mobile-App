package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity6 : AppCompatActivity() {

    private lateinit var babout : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        babout = findViewById(R.id.backContact)

        babout.setOnClickListener {
            val i = Intent (this, MainActivity3::class.java)
            startActivity(i)
        }
    }
}