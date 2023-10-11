package com.example.midtermapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * ViewModelFactory for the [Play] fragments
 *
 * Allows for passing in of the [dao] variable when creating a viewModel
 *
 * @property dao - database for the app
 */
class PlayViewModelFactory(private val dao: ScoreDao)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlayViewModel::class.java)) {
            return PlayViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}