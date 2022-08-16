package com.example.tourismproject.Fragments

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.AndroidViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tourismproject.Adapter.TourAdapter
import com.example.tourismproject.Model.TourModel
import com.example.tourismproject.R
import com.example.tourismproject.ViewModel.TourViewModel


class DetailFragment : Fragment() {

    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var recyclerView: RecyclerView
    var list: List<TourModel> = ArrayList()
    lateinit var tourAdapter: TourAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_detail, container, false)

        toolbar = view.findViewById(R.id.toolbar7)
        recyclerView = view.findViewById(R.id.getDataRecyclerView)

        toolbar.title = "Your Tickets"

        try {
            val viewModel = TourViewModel(requireActivity().application)

            viewModel.getAllData.observe(requireActivity()) {
                tourAdapter = TourAdapter(requireContext(), it)
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
                recyclerView.adapter = tourAdapter
                tourAdapter.notifyDataSetChanged()
            }
        }
        catch (e:Exception){
            e.printStackTrace()
        }
//        try {
//
//            }
//        }
//        catch (e:Exception){
//            e.printStackTrace()
//        }

        return view
    }
}