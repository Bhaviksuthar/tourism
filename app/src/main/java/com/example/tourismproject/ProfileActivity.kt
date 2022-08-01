package com.example.tourismproject

import android.app.Activity
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.squareup.okhttp.internal.DiskLruCache

class ProfileActivity : AppCompatActivity() {

    lateinit var toolbar : androidx.appcompat.widget.Toolbar
    lateinit var photo : ImageView
    lateinit var Name : TextView
    lateinit var Email : TextView
    lateinit var Phone : TextView
    lateinit var EditBtn : MaterialButton
    lateinit var auth: FirebaseAuth
    lateinit var user: FirebaseUser
    lateinit var firestore: FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        auth = Firebase.auth
        user = Firebase.auth.currentUser!!
        firestore = FirebaseFirestore.getInstance()
        toolbar = findViewById(R.id.toolbar2)
        photo = findViewById(R.id.profilePhoto)
        Name = findViewById(R.id.ProfileName)
        Email = findViewById(R.id.ProfileEmail)
        Phone = findViewById(R.id.ProfileNumber)
        EditBtn = findViewById(R.id.EditProfileBtn)
    }
}