package com.example.tourismproject.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toolbar
import com.example.tourismproject.R

class UserDetailsActivity : AppCompatActivity() {

    lateinit var Place : TextView
    lateinit var Name : TextView
    lateinit var Price : TextView
    lateinit var Days : TextView
    lateinit var People : TextView
    lateinit var Address : TextView
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        var name : String
        var place : String
        var id : Int
        var price : Int
        var days : String
        var people : Int
        var address : String

        Place = findViewById(R.id.getPlaceNameTV)
        Name = findViewById(R.id.getOwnerNameTV)
        Price = findViewById(R.id.getPlacePriceTV)
        Days = findViewById(R.id.getPlaceDaysTV)
        People = findViewById(R.id.TotalPeopleTV)
        Address = findViewById(R.id.getAddressTV)
        toolbar = findViewById(R.id.toolbar8)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Your Details"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        try {
            name = intent.getStringExtra("NAME").toString()
            place = intent.getStringExtra("PLACE").toString()
            id = intent.getIntExtra("ID",0)
            price = intent.getIntExtra("MONEY",0)
            days = intent.getStringExtra("Days").toString()
            people = intent.getIntExtra("PEOPLE",0)
            address = intent.getStringExtra("Address").toString()

            Place.text = place
            Name.text = name
            Price.text = "$price"
            Days.text = days
            People.text = "$people"
            Address.text = address
        }
        catch (e:Exception){
            e.printStackTrace()
        }
    }

    override fun onBackPressed() {
        this.finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressed()
            this.finish()
        }
        return super.onOptionsItemSelected(item)
    }
}