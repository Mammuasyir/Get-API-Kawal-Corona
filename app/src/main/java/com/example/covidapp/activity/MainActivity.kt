package com.example.covidapp.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.covidapp.R
import com.example.covidapp.databinding.ActivityMainBinding
import com.example.covidapp.fragment.BerandaFragment
import com.example.covidapp.fragment.InfoFragment
import com.example.covidapp.fragment.ProvinsiFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val fragHome: Fragment = BerandaFragment()
    val fragProvinsi: Fragment = ProvinsiFragment()
    val fragInfo: Fragment = InfoFragment()

    val fm: FragmentManager = supportFragmentManager
    var active: Fragment = fragHome
    private lateinit var menuItem: MenuItem
    private lateinit var menu: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNav()
    }

    private fun setupBottomNav() {

        fm.beginTransaction().add(R.id.nav_container, fragHome).show(fragHome).commit()
        fm.beginTransaction().add(R.id.nav_container, fragProvinsi).hide(fragProvinsi).commit()
        fm.beginTransaction().add(R.id.nav_container, fragInfo).hide(fragInfo).commit()

        menu = btn_nav_view.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        btn_nav_view.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.navigation_beranda -> {
                    callFrag(0, fragHome)
                }
                R.id.navigation_provinsi -> {
                    callFrag(1, fragProvinsi)
                }
                R.id.navigation_info -> {
                    callFrag(2, fragInfo)
                }
            }

            false
        }

    }

    private fun callFrag(i: Int, fragment: Fragment) {
        menuItem = menu.getItem(i)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }



}