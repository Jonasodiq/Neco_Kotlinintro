package com.example.kotlinintro

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinintro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingClass = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(bindingClass.root)

        bindingClass.btnAdd.setOnClickListener {

            val resultValue = bindingClass.editValue.text.toString().toInt()
            Log.d("!!!", "Result = $resultValue")
            when(resultValue) {
                in 0..1000 -> {
                    bindingClass.tvResult.visibility = View.VISIBLE
                    bindingClass.tvResult.text = "You are a beginner blogger"
                }
                in 1001..10000 -> {
                    bindingClass.tvResult.visibility = View.VISIBLE
                    bindingClass.tvResult.text = "You are an average blogger"
                }
                in 10000..100000 -> {
                    bindingClass.tvResult.visibility = View.VISIBLE
                    bindingClass.tvResult.text = "You are an super blogger"
                }

                else -> {
                    bindingClass.tvResult.visibility = View.VISIBLE
                    bindingClass.tvResult.text = "You are a superstar blogger!!!"
                }
            }

        }


    }
}

/*
* Link -> https://www.youtube.com/watch?v=YJSidfZBAAk
* buildFeatures {
       	 viewBinding = true
* }
* */
