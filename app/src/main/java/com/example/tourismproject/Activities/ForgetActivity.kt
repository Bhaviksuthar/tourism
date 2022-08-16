package com.example.tourismproject.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.tourismproject.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ForgetActivity : AppCompatActivity() {

    lateinit var recoverBtn : Button
    lateinit var forgotEmail : EditText
    lateinit var gotoTv : TextView
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget)

        recoverBtn = findViewById(R.id.RecoveryBtn)
        forgotEmail = findViewById(R.id.forgotEmail)
        gotoTv = findViewById(R.id.goTOTV)
        auth = Firebase.auth

        gotoTv.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        recoverBtn.setOnClickListener {
            var email = forgotEmail.text.toString().trim()

            if (email.isEmpty()){
                Toast.makeText(this,"Please enter email first",Toast.LENGTH_SHORT).show()
            }
            else{
                sendPasswordLink(email)
            }
        }
    }

    private fun sendPasswordLink(email: String) {
        auth.sendPasswordResetEmail(email).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(this,"Password reset link send successfully to your email",Toast.LENGTH_LONG).show()
                finish()
                startActivity(Intent(this, LoginActivity::class.java))
            }
            else{
                Toast.makeText(this,"you entered wrong email",Toast.LENGTH_LONG).show()
            }
        }
    }
}