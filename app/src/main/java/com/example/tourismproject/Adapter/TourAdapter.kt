package com.example.tourismproject.Adapter

import android.app.AlertDialog
import android.app.Application
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.tourismproject.Activities.UserDetailsActivity
import com.example.tourismproject.Model.TourModel
import com.example.tourismproject.R
import com.example.tourismproject.ViewModel.TourViewModel

class TourAdapter(context: Context, list:List<TourModel>) : RecyclerView.Adapter<TourAdapter.TourViewHolder>() {

    var context : Context
    private var list : List<TourModel>

    init {
        this.context = context
        this.list = list
    }

    class TourViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var placeName : TextView
        var popMenu : ImageView

        init {
            placeName = itemView.findViewById(R.id.GetNameTV)
            popMenu = itemView.findViewById(R.id.popMenu)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.ticket_layout,parent,false)
        return TourViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.M)
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

        holder.popMenu.setOnClickListener {
            val popMenu : PopupMenu = PopupMenu(it.context,it)
            popMenu.gravity = Gravity.END
            popMenu.menu.add("Cancel The Ticket").setOnMenuItemClickListener {

                val alertDialog : AlertDialog.Builder = AlertDialog.Builder(context)
                    .setTitle("Do you want to cancel the ticket")
                    .setPositiveButton("Yes"){dialog,which->
                        val viewModel : TourViewModel = TourViewModel(Application())
                        viewModel.delete(list[position].id)
                    }
                    .setNegativeButton("No"){dialog,which->
                        dialog.dismiss()
                    }

                alertDialog.show()

                return@setOnMenuItemClickListener true
            }

            popMenu.show()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}