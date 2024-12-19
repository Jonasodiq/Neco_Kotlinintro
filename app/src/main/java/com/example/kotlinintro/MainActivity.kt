package com.example.kotlinintro

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinintro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass : ActivityMainBinding
    val a = 324
    val b = 34

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingClass = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(bindingClass.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bindingClass.btnAdd.setOnClickListener {
            val  result = a + b
            bindingClass.tvText.text = "Alhamdu lillah"
            bindingClass.tvNum.text = "Result: $result."
        }
        bindingClass.btnSub.setOnClickListener {
            val  result = a - b
            bindingClass.tvText.text = "Alhamdu lillah"
            bindingClass.tvNum.text = "Result: $result."
        }
        bindingClass.btnMult.setOnClickListener {
            val  result = a * b
            bindingClass.tvText.text = "Alhamdu lillah"
            bindingClass.tvNum.text = "Result: $result."
        }
        bindingClass.btnDiv.setOnClickListener {
            val  result = a / b
            bindingClass.tvText.text = "Alhamdu lillah"
            bindingClass.tvNum.text = "Result: $result."
        }
    }
}

/*
* Link -> https://developer.android.com/topic/libraries/view-binding
* buildFeatures {
       	 viewBinding = true
* }
* */
