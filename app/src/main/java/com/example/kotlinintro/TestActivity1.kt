package com.example.kotlinintro

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinintro.databinding.ActivityMainBinding
import com.example.kotlinintro.databinding.ActivityTest1Binding

class TestActivity1 : AppCompatActivity() {
    lateinit var bindingClass: ActivityTest1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityTest1Binding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(bindingClass.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val messege = intent.getStringExtra("key") ?: "Default message"
        bindingClass.tvMessege.text = messege
    }

    fun onClickBack(view: View) {
        val userName = bindingClass.editName.text.toString()
        if (userName.isBlank()) {
            bindingClass.editName.error = "Name cannot be empty"
        } else {
            intent.putExtra("key", userName)
            setResult(RESULT_OK, intent)
            finish()
        }
    }



}