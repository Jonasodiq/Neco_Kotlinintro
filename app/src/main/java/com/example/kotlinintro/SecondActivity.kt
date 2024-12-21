package com.example.kotlinintro

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinintro.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var bindingClass : ActivitySecondBinding // binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySecondBinding.inflate(layoutInflater)

        setContentView(bindingClass.root)

        // Ta emot data från MainActivity
        val receivedData = intent.getStringExtra("input_data")
        bindingClass.receivedTextView.text = "Mottaget: $receivedData"

        // Skicka tillbaka data till MainActivity
        bindingClass.returnButton.setOnClickListener {

            val responseText = bindingClass.responseEditText.text.toString()
            if (responseText.isNotEmpty()) {

                val resultIntent = Intent()
                resultIntent.putExtra("returned_data", responseText)
                setResult(Activity.RESULT_OK, resultIntent)
                finish() // Avsluta aktiviteten

            } else {
                Toast.makeText(this, "Vänligen skriv något!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}