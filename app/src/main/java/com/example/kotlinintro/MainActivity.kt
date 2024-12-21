package com.example.kotlinintro

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.kotlinintro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass : ActivityMainBinding // binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingClass = ActivityMainBinding.inflate(layoutInflater) // binding inflate

        setContentView(bindingClass.root)

        bindingClass.sendButton.setOnClickListener {

            val inputText = bindingClass.inputEditText.text.toString()
            if (inputText.isNotEmpty()) {
                // Skapa en Intent för att starta SecondActivity
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("input_data", inputText)
                startActivityForResult(intent, 1) // Starta SecondActivity med förväntan på resultat
            } else {
                Toast.makeText(this, "Vänligen skriv något!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Hantera resultat från SecondActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val returnedData = data?.getStringExtra("returned_data")
            bindingClass.textView.text = "från SecondActivity: $returnedData"
            Toast.makeText(this, "Mottaget från SecondActivity: $returnedData", Toast.LENGTH_LONG).show()
        }
    }
}
