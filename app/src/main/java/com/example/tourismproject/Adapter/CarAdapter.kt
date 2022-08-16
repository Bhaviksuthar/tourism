package com.example.tourismproject.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tourismproject.Activities.PlacesActivity
import com.example.tourismproject.Model.PlacesModel
import com.example.tourismproject.R

public class CarAdapter(context: Context, placeList: ArrayList<PlacesModel>) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    var placeList: ArrayList<PlacesModel>
    var context: Context

    init {
        this.context = context
        this.placeList = placeList
    }

    public class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var placeName: TextView
        var Img: ImageView
        var city: TextView
        var price: TextView

        init {
            placeName = itemView.findViewById(R.id.name)
            Img = itemView.findViewById(R.id.img)
            city = itemView.findViewById(R.id.city)
            price = itemView.findViewById(R.id.price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.places_layout, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        var model: PlacesModel = placeList.get(position)
        holder.placeName.text = model.placeName
        holder.Img.setImageResource(model.Image)
        holder.city.text = model.cityName
        holder.price.text = model.price.toString()

        holder.itemView.setOnClickListener {
            try {
                val intent : Intent = Intent(context,PlacesActivity::class.java)
                intent.putExtra("PLACENAME",placeList.get(position).placeName)
                intent.putExtra("IMAGE",placeList.get(position).Image)
                intent.putExtra("PRICE",placeList.get(position).price)
                context.startActivity(intent)
            }
            catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

    override fun getItemCount(): Int {
        return placeList.size
    }
}