package com.example.androiddasar

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
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

    private fun checkFingerPrint(){
        if(packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
            Log.i("FEATURE", "FINGERPRINT ON")
        }else{
            Log.w("FEATURE", "FINGERPRINT OFF")
        }
    }

    private fun checkPlatformVersion(){
        Log.i("SDK", Build.VERSION.SDK_INT.toString())
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.S){
            Log.i("SDK", "Disable feature because version SDK is lower than 31")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_wolrd )

        initComponen()

        sayHelloTextView.text = resources.getString(R.string.app_name)

        sayHelloButton.setOnClickListener {

            checkFingerPrint()
            checkPlatformVersion()

            val sample = resources.openRawResource(R.raw.simple)
                .bufferedReader()
                .use { it.readText() }

            Log.i("RAW", sample)

            val json = assets.open("simple.json")
                .bufferedReader()
                .use { it.readText() }

            Log.i("ASSET", json)

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