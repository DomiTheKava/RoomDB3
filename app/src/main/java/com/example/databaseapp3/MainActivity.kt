package com.example.databaseapp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        setupActionBarWithNavController(findNavController(R.id.fragmentContainerView)) // app wont load
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navc = findNavController(R.id.fragmentContainerView)
//        return navc.navigateUp() || super.onSupportNavigateUp()
//    }
}