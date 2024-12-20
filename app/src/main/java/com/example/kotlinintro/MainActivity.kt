package com.example.kotlinintro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinintro.constance.Constance
import com.example.kotlinintro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingClass = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(bindingClass.root)

    }

    fun onClickTest2(view: View) {
        val intent = Intent(this, TestActivity2::class.java)
        startActivity(intent)
    }

    fun onClockBack(view: View) {
        finish()
    }
}

/*
* Link -> https://www.youtube.com/watch?v=kDUIlwkpBaQ
* Link -> https://developer.android.com/guide/topics/resources/providing-resources?hl=ru
* buildFeatures {
       	 viewBinding = true
* }
* */
