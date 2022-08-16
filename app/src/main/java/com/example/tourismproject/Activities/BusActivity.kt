package com.example.tourismproject.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tourismproject.Adapter.BusAdapter
import com.example.tourismproject.Model.PlacesModel
import com.example.tourismproject.R

class BusActivity : AppCompatActivity() {

    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var recyclerView: RecyclerView
    lateinit var placeList: ArrayList<PlacesModel>
    lateinit var adapter: BusAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus)

        toolbar = findViewById(R.id.toolbar3)
        recyclerView = findViewById(R.id.recyclerView)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Available Places"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        placeList = ArrayList()
        placeList.add(PlacesModel("Pavagadh",R.drawable.pavagadh,"Panchmahal",3000))
        placeList.add(PlacesModel("Science City",R.drawable.sciencecenter,"Ahmedabad",2000))
        placeList.add(PlacesModel("RaniKi Vav",R.drawable.ranikivav,"Ahmedabad",2000))
        placeList.add(PlacesModel("Modhera Temple",R.drawable.mothera,"Mehsana",1300))
        placeList.add(PlacesModel("Somnath Temple",R.drawable.somnath,"Patan",2300))
        placeList.add(PlacesModel("Vadodara museum",R.drawable.museum,"Vadodara",1500))

        adapter = BusAdapter(this,placeList)
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