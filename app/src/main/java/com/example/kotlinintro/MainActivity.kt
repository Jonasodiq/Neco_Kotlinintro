package com.example.kotlinintro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.kotlinintro.constance.Constance
import com.example.kotlinintro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Binding för att enkelt hantera UI-element
    lateinit var bindingClass : ActivityMainBinding

    // Variabler för att spara användarens data
    private var login: String = "empty"
    private var password: String = "empty"
    private var firstName: String = "empty"
    private var lastName: String = "empty"
    private var nickName: String = "empty"
    private var avatarImgId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initiera binding för att koppla layout till koden
        bindingClass = ActivityMainBinding.inflate(layoutInflater)

        // Aktivera modern UI (edge-to-edge navigation)
        enableEdgeToEdge()
        setContentView(bindingClass.root)
    }

    // Hanterar resultat från aktiviteter som Sign In och Sign Up
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Constance.REQUEST_CODE_SIGN_IN) {
            val l = data?.getStringExtra(Constance.LOGIN)
            val p = data?.getStringExtra(Constance.PASSWORD)

            // Kontrollera om inloggningsuppgifter matchar
            if (login == l && password == p) {

                // Visa användarens avatar och information
                bindingClass.imgAvatar.visibility = View.VISIBLE
                bindingClass.imgAvatar.setImageResource(avatarImgId)
                val textInfo = "$firstName $lastName $nickName"
                bindingClass.tvInfo.text = textInfo
                bindingClass.btnHide.visibility == View.GONE // Dölj Hide-knappen
                bindingClass.btnExit.text = "Exit" // Ändra text på Exit-knappen

            } else {
                // Visa standardbild och meddelande om användaren inte hittas
                bindingClass.imgAvatar.visibility = View.VISIBLE
                bindingClass.imgAvatar.setImageResource(R.drawable.man)
                bindingClass.tvInfo.text = "User not found"
            }

        } else if (resultCode == Constance.REQUEST_CODE_SIGN_UP) { // Hantera Sign Up-resultat

            // Hämta data från Intent och uppdatera variabler
            login = data?.getStringExtra(Constance.LOGIN) !!
            password = data.getStringExtra(Constance.PASSWORD) !!
            firstName = data.getStringExtra(Constance.FNAME) !!
            lastName = data.getStringExtra(Constance.LNAME) !!
            nickName = data.getStringExtra(Constance.NNAME) !!
            avatarImgId = data.getIntExtra(Constance.AVATAR_ID, 0)

            // Visa användarens avatar och information
            bindingClass.imgAvatar.setImageResource(avatarImgId)
            val textInfo = "$firstName $lastName $nickName"
            bindingClass.tvInfo.text = textInfo
            bindingClass.btnHide.visibility == View.GONE // Dölj Hide-knappen
            bindingClass.btnExit.text = "Exit" // Ändra text på Exit-knappen
        }

        Log.d("onActivityResult", "Request Code: $requestCode, Result Code: $resultCode")
        data?.extras?.let { bundle ->
            for (key in bundle.keySet()) {
                Log.d("onActivityResult", "$key -> ${bundle.get(key)}")
            }
        }
    }

    // Metod för att hantera Sign In-knappen
    fun onClickSingIn(view: View) {

        // Om användaren redan är inloggad, återställ UI
        if (bindingClass.imgAvatar.isVisible && bindingClass.tvInfo.text.toString() != "User not found") {
            bindingClass.imgAvatar.visibility = View.INVISIBLE
            bindingClass.tvInfo.text = ""
            bindingClass.btnHide.visibility = View.VISIBLE
            bindingClass.btnExit.text = getString(R.string.sign_in)
        } else {
            // Starta Sign In-aktivitet
            val intent = Intent(this, SignInUpActivity::class.java)
            intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
            startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_IN)
        }
    }

    // Metod för att hantera Sign Up-knappen
    fun onClickSingUp(view: View) {
        // Starta Sign Up-aktivitet
        val intent = Intent(this, SignInUpActivity::class.java)
        intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
        startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_UP)
    }

}

/*
* Link -> https://www.youtube.com/watch?v=crSf1V3UJS0
* Link -> https://neco-desarrollo.es/2021/04/%D1%83%D1%80%D0%BE%D0%BA-18-%D0%BF%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D0%BA%D0%B0-%D0%BA%D0%BE%D0%B4-%D1%83%D1%80%D0%BE%D0%BA%D0%B0
* buildFeatures {
       	 viewBinding = true
* }
* */
