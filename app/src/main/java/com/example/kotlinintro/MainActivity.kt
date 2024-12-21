package com.example.kotlinintro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinintro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingClass = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(bindingClass.root)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 100 && resultCode == RESULT_OK && data != null) {
            val returnedData = data.getStringExtra("key")
            bindingClass.tvMessageMain.text = returnedData
            Log.d("!!!", "returnedData: $returnedData")
        }
    }

    fun onClickTest1(view: View) {
        val i = Intent(this, TestActivity1::class.java)
        i.putExtra("key", "What is your name?")
        //startActivity(i)
        startActivityForResult(i, 100)
    }


}

/*
* Link -> https://www.youtube.com/watch?v=kDUIlwkpBaQ
* Link -> https://developer.android.com/guide/topics/resources/providing-resources?hl=ru
* buildFeatures {
       	 viewBinding = true
* }
* */
