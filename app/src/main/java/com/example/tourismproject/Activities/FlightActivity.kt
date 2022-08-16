package com.example.tourismproject.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tourismproject.Adapter.BusAdapter
import com.example.tourismproject.Adapter.FlightAdapter
import com.example.tourismproject.Model.PlacesModel
import com.example.tourismproject.R

class FlightActivity : AppCompatActivity() {

    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var recyclerView: RecyclerView
    lateinit var placeList: ArrayList<PlacesModel>
    lateinit var adapter: FlightAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight)

        toolbar = findViewById(R.id.toolbar5)
        recyclerView = findViewById(R.id.recyclerView3)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Available Places"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        placeList = ArrayList()
        placeList.add(PlacesModel("Taj Mahal",R.drawable.tajmaha,"Delhi",10000))
        placeList.add(PlacesModel("Goa Beaches",R.drawable.goa,"Goa",30000))
        placeList.add(PlacesModel("Mayapur Iskcon",R.drawable.mayapur,"West Bengal",11500))
        placeList.add(PlacesModel("Jammu Kashmir",R.drawable.jammu,"Jammu Kashmir",23000))
        placeList.add(PlacesModel("Amarnath",R.drawable.amarnath,"Jammu Kashmir",15550))
        placeList.add(PlacesModel("Kedarnath",R.drawable.kedarnath,"UttaraKhand",15000))

        adapter = FlightAdapter(this,placeList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
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