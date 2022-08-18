package com.example.tourismproject.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.tourismproject.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlin.collections.HashMap

class SignUpActivity : AppCompatActivity() {

    lateinit var emailEdt : EditText
    lateinit var passwordEdt : EditText
    lateinit var phoneEdt : EditText
    lateinit var usernameEdt : EditText
    lateinit var signUpBtn : Button
    lateinit var userTV : TextView
    lateinit var email: String
    lateinit var username: String
    lateinit var password: String
    lateinit var phone: String
    lateinit var auth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        emailEdt = findViewById(R.id.EmailEdt)
        passwordEdt = findViewById(R.id.PasswordEdt)
        signUpBtn = findViewById(R.id.SignUpBtn)
        userTV = findViewById(R.id.signInTXT)
        usernameEdt = findViewById(R.id.user_name)
        phoneEdt = findViewById(R.id.phone)
        auth = Firebase.auth
        val user : FirebaseUser? = auth.currentUser

        userTV.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }


        signUpBtn.setOnClickListener {

            try {

               email = emailEdt.text.toString().trim()
               password = passwordEdt.text.toString().trim()
               username = usernameEdt.text.toString().trim()
               phone = phoneEdt.text.toString().trim()

                if (email.isEmpty() || password.isEmpty() || username.isEmpty() || phone.isEmpty()) {
                    Toast.makeText(this, "Please enter all required fields", Toast.LENGTH_SHORT)
                        .show()
                } else if (password.length <= 7) {
                    Toast.makeText(this, "Password length should be more than 7 character", Toast.LENGTH_SHORT).show()
                } else {
//                do signUp code
//                    val phoneNo = Integer.parseInt(phone)

                    createUser(email, password)
                    addData(email,password,username,phone)
                }
            }
            catch (e : Exception){
                e.message?.let { it1 -> Log.e("TAG", it1) }
            }
        }

    }

    private fun addData(email : String,password : String ,username : String ,phone : String){
        try {

            val reference : DatabaseReference = FirebaseDatabase.getInstance().getReference("UserDetails").child(username)

            val map = HashMap<String,Any>()
            map["USERNAME"] = username
            map["EMAIL"] = email
            map["PASSWORD"] = password
            map["PHONE"] = phone


            val reference2 : DatabaseReference = FirebaseDatabase.getInstance().getReference("UserName")
            val map2 = HashMap<String,Any>()
            map2["USER"] = username

            reference2.setValue(map2).addOnSuccessListener {}.addOnFailureListener {}

            reference.setValue(map).addOnSuccessListener {
                Toast.makeText(this,"Added",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,"error = "+it.message,Toast.LENGTH_SHORT).show()
            }
        }
        catch (e : Exception){
            e.message?.let { it-> Log.e("TAG",it) }
        }

    }

    private fun createUser(email:String, password:String){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(this,"SignUp successful",Toast.LENGTH_SHORT).show()
                authenticateUser()
            }
        }
    }

    private fun authenticateUser(){
        val user : FirebaseUser? = auth.currentUser
        user?.sendEmailVerification()?.addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Email verification link sent successfully to your email", Toast.LENGTH_SHORT).show()
                auth.signOut()
                finish()
                startActivity(Intent(this, LoginActivity::class.java))
            }
            else{
                Toast.makeText(this,"Email is already registered",Toast.LENGTH_SHORT).show()
            }
        }
    }
}