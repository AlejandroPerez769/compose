package com.example.prueba_menu_lateral

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.prueba_menu_lateral.databinding.ActivityMainBinding
import com.example.prueba_menu_lateral.databinding.InboxBinding
import com.example.prueba_menu_lateral.databinding.NavHeaderBinding

class Inbox : AppCompatActivity() {

    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var binding: InboxBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = InboxBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        drawerLayout = binding.main
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout ,binding.toolbar, R.string.abrir, R.string.cerrar)

        val headerView = binding.navegacion.getHeaderView(0)
        val headerBinding = NavHeaderBinding.bind(headerView)
        val options = resources.getStringArray(R.array.emails_array)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, options)
        headerBinding.spinner.adapter = adapter

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        binding.navegacion.setNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.parte1 -> {

                    val intent = Intent(this, Inbox::class.java)
                    startActivity(intent)

                }

                R.id.parte2 -> {

                    val intent = Intent(this, Outbox::class.java)
                    startActivity(intent)
                }

                R.id.parte3 -> {

                    val intent = Intent(this, Spam::class.java)
                    startActivity(intent)

                }

                R.id.parte4 -> {

                    val intent = Intent(this, Trash::class.java)
                    startActivity(intent)

                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

    }
}