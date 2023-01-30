package com.example.androiddasar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PageTwo : AppCompatActivity() {
    private lateinit var constraintButtonBack: Button

    private fun initComponen(){
        constraintButtonBack = findViewById(R.id.constraintButtonBack)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagetwo)

        initComponen()

        constraintButtonBack.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}