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

        bindingClass.btnAdd.setOnClickListener {

            val resultValue = bindingClass.editValue.text.toString()
            Log.d("!!!", "Result = $resultValue")

            when(resultValue) {
                Constance.TEACHER -> {
                    bindingClass.tvResult.visibility = View.VISIBLE
                    val tempText = "Your salary is ${Constance.TEACHER_SALARY} kr"
                    if (bindingClass.editKey.text.toString() == Constance.TEACHER_KEY) {
                        bindingClass.tvResult.text = tempText
                    } else {
                        bindingClass.tvResult.text = "Incorrect"
                    }
                }
                Constance.ACCOUNTANT -> {
                    bindingClass.tvResult.visibility = View.VISIBLE
                    val tempText = "Your salary is ${Constance.ACCOUNTANT_SALARY} kr"
                    if (bindingClass.editKey.text.toString() == Constance.ACCOUNTANT_KEY) {
                        bindingClass.tvResult.text = tempText
                    } else {
                        bindingClass.tvResult.text = "Incorrect"
                    }
                }
                Constance.DEVELOPER -> {
                    bindingClass.tvResult.visibility = View.VISIBLE
                    val tempText = "Your salary is ${Constance.DEVELOPER_SALARY} kr"
                    if (bindingClass.editKey.text.toString() == Constance.DEVELOPER_KEY) {
                        bindingClass.tvResult.text = tempText
                    } else {
                        bindingClass.tvResult.text = "Incorrect"
                    }
                }

                else -> {
                    bindingClass.tvResult.visibility = View.VISIBLE
                    bindingClass.tvResult.text = "Can't be empty"
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
