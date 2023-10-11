package com.example.midtermapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * factory for generating TasksViewModels
 */
class ScoreViewModelFactory(private val dao: ScoreDao)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TasksViewModel::class.java)) {
            return TasksViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
    /*override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TasksViewModel::class.java)) {
            return TasksViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }*/
}