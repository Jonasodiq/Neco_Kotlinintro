package com.example.kotlinintro

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinintro.constance.Constance
import com.example.kotlinintro.databinding.ActivitySignInUpBinding

class SignInUpActivity : AppCompatActivity() {
    // Binding för att enkelt hantera UI-element
    lateinit var binding: ActivitySignInUpBinding
    // Variabel för att lagra aktuellt läge (Sign In eller Sign Up)
    private var signState = "empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initiera binding för att koppla layout till koden
        binding = ActivitySignInUpBinding.inflate(layoutInflater)
        // Aktivera modern UI (edge-to-edge navigation)
        enableEdgeToEdge()
        setContentView(binding.root)
        // Hanterar padding för att undvika överlappning med systemfält
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Hämta inloggningsstatus från intent
        signState = intent.getStringExtra(Constance.SIGN_STATE)!!
        // Om det är Sign In-läge, döljer vi extra fält som inte behövs
        if (signState == Constance.SIGN_IN_STATE) {

            binding.editFname.visibility = View.GONE
            binding.editLname.visibility = View.GONE
            binding.editNname.visibility = View.GONE
            binding.btnAvatar.visibility = View.INVISIBLE
        }
    }

    // Hanterar knapptryckning på "Done"-knappen
    fun onClickDone(view: View) {
        if (signState == Constance.SIGN_UP_STATE) { // Om vi är i Sign Up-läge

            val intent = Intent()
            intent.putExtra( Constance.LOGIN, binding.editLogin.text.toString()) // Hämta användarnamn
            intent.putExtra( Constance.PASSWORD, binding.editPassword.text.toString()) // Hämta lösenord
            intent.putExtra( Constance.FNAME, binding.editFname.text.toString()) // Hämta förnamn
            intent.putExtra( Constance.LNAME, binding.editLname.text.toString()) // Hämta efternamn
            intent.putExtra( Constance.NNAME, binding.editNname.text.toString()) // Hämta smeknamn
            intent.putExtra( Constance.AVATAR_ID, R.drawable.developer) // Lägg till avatar-ID
            setResult(RESULT_OK, intent) // Skicka tillbaka resultatet
            finish() // Avsluta aktiviteten

        } else if (signState == Constance.SIGN_IN_STATE) { // Om vi är i Sign In-läge
            // Skicka bara användarnamn och lösenord
            intent.putExtra( Constance.LOGIN, binding.editLogin.text.toString())
            intent.putExtra( Constance.PASSWORD, binding.editPassword.text.toString())
            setResult(RESULT_OK, intent) // Skicka tillbaka resultatet
            finish() // Avsluta aktiviteten

        }
    }

    // Hanterar knapptryckning på "Avatar"-knappen
    fun onClickAvatar(view: View) {
        // Ändra avatar-bilden till en förvald bild
        binding.imgSign.setImageResource(R.drawable.developer)
    }
}