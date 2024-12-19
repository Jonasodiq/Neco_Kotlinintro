package com.example.kotlinintro

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    fun onClickTest(view : View) {

        val tvText = findViewById<TextView>(R.id.tv_text)
        tvText.text = "Alhamdu lillah"
    }
}

/*
* Linl https://www.youtube.com/watch?v=69mObaqD7OI
*
* The activity lifecycle -> https://developer.android.com/guide/components/activities/activity-lifecycle?hl=ru
*
*
*  */