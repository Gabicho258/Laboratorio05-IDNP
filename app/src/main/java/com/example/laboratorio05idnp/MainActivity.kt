package com.example.laboratorio05idnp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.laboratorio05idnp.fragments.Actividad1Fragment
import com.example.laboratorio05idnp.fragments.Actividad2Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bottomNavigation = findViewById(R.id.bottomNavigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            val selectedFragment: Fragment = when (item.itemId) {
                R.id.menuActivity1 -> Actividad1Fragment()
                R.id.menuActivity2 -> Actividad2Fragment()
                else -> Actividad1Fragment()
            }
            openFragment(selectedFragment)
            true
        }

        bottomNavigation.selectedItemId = R.id.menuActivity1
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}