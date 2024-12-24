package com.example.kotlinintro

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.kotlinintro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        openFrag(BlankFragment.newInstance(), R.id.place_holder)
        openFrag(BlankFragment2.newInstance(), R.id.place_holder2)
        dataModel.messageForActivity.observe(this,{
            binding.textView.text = it
        })

    }

    private fun openFrag(f: Fragment, idHolder: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}

/*
* Link -> https://www.youtube.com/watch?v=EkXD07ps6Qo
* Link -> https://developer.android.com/guide/fragments/communicate?hl=ru-419
* Link -> https://developer.android.com/guide/fragments/lifecycle?hl=ru
*
* */