package com.example.tourismproject.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.tourismproject.Model.TourModel
import com.example.tourismproject.R
import com.example.tourismproject.ViewModel.TourViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar

class TicketActivity : AppCompatActivity() {

    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var name : EditText
    lateinit var TotalPeople : EditText
    lateinit var confirmBtn : MaterialButton
    lateinit var placeName : TextView
    lateinit var TotalPrice : TextView
    lateinit var TotalDays : TextView
    lateinit var BookBtn : MaterialButton
    lateinit var ClearBtn: MaterialButton
    lateinit var viewModel : TourViewModel
    lateinit var layout : RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket)

        toolbar = findViewById(R.id.toolbar6)
        name = findViewById(R.id.OwnerName)
        TotalPeople = findViewById(R.id.totalPeople)
        confirmBtn = findViewById(R.id.confirmBtn)
        placeName = findViewById(R.id.PlaceNameTV)
        TotalPrice = findViewById(R.id.TotalPriceTV)
        TotalDays = findViewById(R.id.TotalDays)
        BookBtn = findViewById(R.id.TicketBtn)
        ClearBtn = findViewById(R.id.ClearBtn)
        viewModel = TourViewModel(application)
        layout = findViewById(R.id.relativeLayout)


        setSupportActionBar(toolbar)
        supportActionBar?.title = "Book your online Ticket"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val price : Int
        val place : String
        val days : String
        var getPrice : Int
        var getPeople : Int
        var originalPrice : Int = 0
        var totalPrice : Int = 0

        try {
            price = intent.getIntExtra("Price",0)
            place = intent.getStringExtra("Place").toString()
            days = intent.getStringExtra("Days").toString()
            placeName.text = place
            TotalPrice.text = price.toString()
            TotalDays.text = days
            originalPrice = price
        }
        catch (e: Exception){
            e.printStackTrace()
        }

        confirmBtn.setOnClickListener {

            if (TotalPeople.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter no. of people",Toast.LENGTH_SHORT).show()
            }


            getPeople = Integer.parseInt(TotalPeople.text.toString())
            getPrice =  Integer.parseInt(TotalPrice.text.toString())
            totalPrice = getPrice*getPeople
            TotalPrice.text = "$totalPrice"
            confirmBtn.isClickable = false
        }

        ClearBtn.setOnClickListener {
            confirmBtn.isClickable = true
            TotalPeople.text = null
            TotalPrice.text = "$originalPrice"
        }

        BookBtn.setOnClickListener {
           try {
               val getName = name.text.toString()
               val getTotalPeople = Integer.parseInt(TotalPeople.text.toString())
               val getTotalPrice = Integer.parseInt(TotalPrice.text.toString())
               val getPlaceName = placeName.text.toString()
               val getDays = TotalDays.text.toString()

               if (getName.isEmpty() || getTotalPeople.toString().isEmpty()){
                   Toast.makeText(this,"Please enter required field",Toast.LENGTH_SHORT).show()
               }
               else{
                    var tourModel : TourModel = TourModel(
                        0,
                        getPlaceName,
                        getTotalPeople,
                        getTotalPrice,
                        getName,
                        "58-Number Ram Chowk Garden, b/h police station, shree nagar, Surat",
                        getDays
                    )

                   viewModel.Add(tourModel)
                   Toast.makeText(this,"Your Online Ticket confirmation successFull",Toast.LENGTH_LONG).show()
                   startActivity(Intent(this,PlacesActivity::class.java))
                   finish()
               }
           }
           catch (e:Exception){
               e.printStackTrace()
           }
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