package com.example.tourismproject.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tourismproject.Fragments.DashBoardFragment
import com.example.tourismproject.Fragments.DetailFragment
import com.example.tourismproject.Fragments.ProfileFragment
import com.example.tourismproject.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashBoardActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        bottomNavigationView = findViewById(R.id.bottomNavigation)



        val dashBoardFragment : DashBoardFragment = DashBoardFragment()
        val profileFragment : ProfileFragment = ProfileFragment()
        val detailFragment : DetailFragment = DetailFragment()

        bottomNavigationView.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.dashBoard -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame,dashBoardFragment).commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.profile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame,profileFragment).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.details -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame, detailFragment)
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false

        }

        bottomNavigationView.selectedItemId = R.id.dashBoard
    }
}