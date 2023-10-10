package com.example.midtermapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    /**
     * Main Activity
     *
     * Serves as placeholder for navHost
     *
     * @author Timothy Chan
     */
    lateinit var sharedViewModel: PlayViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val application = requireNotNull(this).application
        val dao = TaskDatabase.getInstance(application).taskDao
        val viewModelFactory = PlayViewModelFactory(dao)
        sharedViewModel = ViewModelProvider(this, viewModelFactory).get(PlayViewModel::class.java)

    }
}