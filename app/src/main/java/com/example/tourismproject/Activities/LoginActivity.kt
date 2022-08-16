package com.example.tourismproject.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tourismproject.R
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    lateinit var loginEmail : EditText
    lateinit var loginPassword : EditText
    lateinit var signInBtn : MaterialButton
    lateinit var forgotTV : TextView
    lateinit var signUpTV : TextView
    lateinit var email : String
    lateinit var password : String
    lateinit var userName : EditText
    lateinit var auth: FirebaseAuth
    lateinit var reference: DatabaseReference
    lateinit var userStr : Any


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginEmail = findViewById(R.id.LoginEmailEdt)
        loginPassword = findViewById(R.id.LoginPasswordEdt)
        signInBtn = findViewById(R.id.SignInBtn)
        forgotTV = findViewById(R.id.forgotPasswordTXT)
        signUpTV = findViewById(R.id.signUpTXT)
        auth = Firebase.auth
        val user : FirebaseUser? = auth.currentUser
        userStr = ""


        try {
            if (user != null){
                this.finish()
                startActivity(Intent(applicationContext, MainActivity::class.java))
            }
        }
        catch (e : Exception){
            e.printStackTrace()
        }


        signInBtn.setOnClickListener {
            email = loginEmail.text.toString().trim()
            password = loginPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Please enter all required fields", Toast.LENGTH_SHORT).show()
            }
            else{
//                do signIn code
                sighInUser(email,password)
            }
        }

        signUpTV.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        forgotTV.setOnClickListener {
            startActivity(Intent(this, ForgetActivity::class.java))
        }
    }

    private fun sighInUser(email: String, password: String) {

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful){
                checkUserIsVerified()
            }
        }
    }



    private fun checkUserIsVerified(){
        val User : FirebaseUser = auth.currentUser!!
        if (User.isEmailVerified){
            Toast.makeText(this,"Sign In Successful",Toast.LENGTH_SHORT).show()
            finish()
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
        else{
            Toast.makeText(this,"Verify your email first",Toast.LENGTH_SHORT).show()
        }
    }
}