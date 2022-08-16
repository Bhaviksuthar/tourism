package com.example.tourismproject.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tourismproject.Adapter.BusAdapter
import com.example.tourismproject.Adapter.CarAdapter
import com.example.tourismproject.Model.PlacesModel
import com.example.tourismproject.R

class CarActivity : AppCompatActivity() {

    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var recyclerView: RecyclerView
    lateinit var placeList: ArrayList<PlacesModel>
    lateinit var adapter: CarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car)

        toolbar = findViewById(R.id.toolbar4)
        recyclerView = findViewById(R.id.recyclerView2)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Available Places"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        placeList = ArrayList()
        placeList.add(PlacesModel("Flower Garden",R.drawable.flower,"Surat",150))
        placeList.add(PlacesModel("Statue of Unity",R.drawable.statue,"Vadodara",1500))
        placeList.add(PlacesModel("Narmada River",R.drawable.narmada,"Vadodara",750))
        placeList.add(PlacesModel("Gopi Talav",R.drawable.gopitalav,"Surat",250))
        placeList.add(PlacesModel("Dumas Beach",R.drawable.dumas,"Surat",300))
        placeList.add(PlacesModel("Iskcon surat temple",R.drawable.iskcon,"Surat",150))

        adapter = CarAdapter(this,placeList)
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