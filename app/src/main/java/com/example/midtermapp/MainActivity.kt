package com.example.midtermapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    /**
     * Main Activity
     *
     * Serves as placeholder for navHost
     * Contains the shared viewModel for the [Play] fragments
     *
     * @author Timothy Chan
     */
    lateinit var sharedViewModel: PlayViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val application = requireNotNull(this).application
        val dao = ScoreDatabase.getInstance(application).scoreDao
        val viewModelFactory = PlayViewModelFactory(dao)
        sharedViewModel = ViewModelProvider(this, viewModelFactory).get(PlayViewModel::class.java)

    }
}