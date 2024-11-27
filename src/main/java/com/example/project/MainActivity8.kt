package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity8 : AppCompatActivity() {

    private lateinit var bfaq : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        bfaq = findViewById(R.id.backfaq)

        bfaq.setOnClickListener {
            val i = Intent (this, MainActivity::class.java)
            startActivity(i)
        }

    }
}