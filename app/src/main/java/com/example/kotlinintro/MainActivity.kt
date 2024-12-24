package com.example.kotlinintro

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinintro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Aktivera ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Hantera systeminpassningar
        ViewCompat.setOnApplyWindowInsetsListener(binding.drawer) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.nv.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.item1 -> {
                    Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT).show()
                }
                R.id.item2 -> Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show()
                R.id.item3 -> Toast.makeText(this, "Item 3", Toast.LENGTH_SHORT).show()
                R.id.item4 -> Toast.makeText(this, "Item 4", Toast.LENGTH_SHORT).show()
                R.id.item11 -> Toast.makeText(this, "Item 11", Toast.LENGTH_SHORT).show()
                R.id.item22 -> Toast.makeText(this, "Item 22", Toast.LENGTH_SHORT).show()
                R.id.item33 -> Toast.makeText(this, "Item 33", Toast.LENGTH_SHORT).show()
                R.id.item44 -> Toast.makeText(this, "Item 44", Toast.LENGTH_SHORT).show()
            }
            binding.drawer.closeDrawer(GravityCompat.START)
            true }

        // Öppna navigation drawer när "Open Menu"-knappen klickas
        binding.open.setOnClickListener {
            binding.drawer.openDrawer(GravityCompat.START)
        }
    }

    override fun onBackPressed() {
        // Stäng navigation drawer om den är öppen när bakåtknappen trycks
        if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
            binding.drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}

/*
* Link -> https://www.youtube.com/watch?v=xDA9uwY7k0c
* Link -> https://developer.android.com/reference/com/google/android/material/navigation/NavigationView
*
* */