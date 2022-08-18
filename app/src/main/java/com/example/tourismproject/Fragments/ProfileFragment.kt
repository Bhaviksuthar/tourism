package com.example.tourismproject.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.tourismproject.Activities.LoginActivity
import com.example.tourismproject.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class ProfileFragment : Fragment() {

    lateinit var auth : FirebaseAuth
    lateinit var logOut : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_profile, container, false)

        logOut = view.findViewById(R.id.LogOutBtn)
        auth = Firebase.auth

        logOut.setOnClickListener {
           auth.signOut()
            startActivity(Intent(requireContext(),LoginActivity::class.java))
            requireActivity().finish()
        }

        return view
    }

}