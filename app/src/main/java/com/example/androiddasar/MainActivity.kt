package com.example.androiddasar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var sayHelloButton: Button
    private lateinit var sayHelloTextView: TextView
    private lateinit var nextPageTwoButton: Button

    private fun initComponen(){
        nameEditText = findViewById(R.id.nameEditText)
        sayHelloButton = findViewById(R.id.sayHelloButton)
        sayHelloTextView = findViewById(R.id.sayHelloTextView)
        nextPageTwoButton = findViewById(R.id.nextPageTwoButton)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_wolrd )

        initComponen()

        sayHelloTextView.text = resources.getString(R.string.app_name)

        sayHelloButton.setOnClickListener {
            Log.d("MainActivity","Click sayHelloButton")
            Log.i("ValueResources", resources.getInteger(R.integer.maxPage).toString())
            Log.i("ValueResources", resources.getBoolean(R.bool.isProductionMode).toString())
            Log.i("ValueResources", resources.getIntArray(R.array.numbers).joinToString(separator = ","))
            Log.i("ValueResources", resources.getColor(R.color.background, theme).toString())

            sayHelloButton.setBackgroundColor(resources.getColor(R.color.background, theme))


            val name = nameEditText.text.toString()
            sayHelloTextView.text = resources.getString(R.string.sayHelloTextView, name)


            resources.getStringArray(R.array.names).forEach {
                Log.i("JF", it)
            }
        }

        nextPageTwoButton.setOnClickListener {
            Log.e("Button Next", "Tombol pindah halaman")
            val intent = Intent(this, PageTwo::class.java)
            startActivity(intent)
        }


    }
}