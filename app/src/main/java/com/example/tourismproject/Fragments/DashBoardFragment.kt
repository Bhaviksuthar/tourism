package com.example.tourismproject.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import com.example.tourismproject.Activities.BusActivity
import com.example.tourismproject.R
import android.content.Intent
import com.example.tourismproject.Activities.CarActivity
import com.example.tourismproject.Activities.FlightActivity

class DashBoardFragment : Fragment() {

    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var carTour : ImageView
    lateinit var BusTour : ImageView
    lateinit var FlightTour : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_dash_board, container, false)

        toolbar = view.findViewById(R.id.toolbar)
        carTour = view.findViewById(R.id.carRide)
        BusTour = view.findViewById(R.id.BusRide)
        FlightTour = view.findViewById(R.id.FlightRide)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        BusTour.setOnClickListener {
            try {
                startActivity(Intent(requireActivity(),BusActivity::class.java))
            }
            catch (e : Exception){
                e.printStackTrace()
            }

        }

        carTour.setOnClickListener {
            startActivity(Intent(requireActivity(),CarActivity::class.java))
        }

        FlightTour.setOnClickListener {
            startActivity(Intent(requireActivity(),FlightActivity::class.java))
        }
    }
}