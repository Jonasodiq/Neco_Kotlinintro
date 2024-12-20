package com.example.kotlinintro

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
}

/*
* Link -> https://www.youtube.com/watch?v=nnTUXD0-U7A
* Link -> https://developer.android.com/guide/topics/resources/providing-resources?hl=ru
* buildFeatures {
       	 viewBinding = true
* }
* */
