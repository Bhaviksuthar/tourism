package com.example.tourismproject.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tourismproject.Activities.UserDetailsActivity
import com.example.tourismproject.Model.TourModel
import com.example.tourismproject.R

class TourAdapter(context: Context, list:List<TourModel>) : RecyclerView.Adapter<TourAdapter.TourViewHolder>() {

    var context : Context
    private var list : List<TourModel>

    init {
        this.context = context
        this.list = list
    }

    class TourViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var placeName : TextView

        init {
            placeName = itemView.findViewById(R.id.GetNameTV)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.ticket_layout,parent,false)
        return TourViewHolder(view)
    }

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        val model : TourModel = list[position]
        holder.placeName.text = model.placeName

        holder.itemView.setOnClickListener {
            try {
                val intent = Intent(context,UserDetailsActivity::class.java)
                intent.putExtra("ID",model.id)
                intent.putExtra("PLACE",model.placeName)
                intent.putExtra("PEOPLE",model.people)
                intent.putExtra("MONEY",model.money)
                intent.putExtra("Days",model.days)
                intent.putExtra("Address",model.address)
                intent.putExtra("NAME",model.name)
                context.startActivity(intent)
            }
            catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}