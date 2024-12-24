package com.example.kotlinintro

import android.os.Bundle
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
* Link -> https://www.youtube.com/watch?v=InA9RaoKpxM
* Link -> https://developer.android.com/reference/androidx/drawerlayout/widget/DrawerLayout
*
* */