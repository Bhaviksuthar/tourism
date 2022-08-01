package com.example.tourismproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class DashBoardActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var toolbar : androidx.appcompat.widget.Toolbar
    lateinit var user: FirebaseUser



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        auth = Firebase.auth
        toolbar = findViewById(R.id.toolbar)
        user = Firebase.auth.currentUser!!

        setSupportActionBar(toolbar)
        supportActionBar?.title = "DashBoard"

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuitem,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout){
            auth.signOut()
            finish()
            startActivity(Intent(applicationContext,LoginActivity::class.java))
        }
        else{
            startActivity(Intent(applicationContext,ProfileActivity::class.java))
        }
        return super.onOptionsItemSelected(item)

    }
}