package com.example.midtermapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * viewModel for the [Play] fragments
 *
 * Uses MutableLiveData to store information so that observers can react to it.
 * Contains temp data and methods for adding to database
 *
 * @property dao - database for the application
 */
class PlayViewModel(val dao: ScoreDao) : ViewModel() {

    val guessAttempts: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val playerName: MutableLiveData<String> by lazy {
        MutableLiveData<String>("anonymous")
    }

    // initialize guess attempts to 0 whenever a viewModel is created
    init {
        guessAttempts.value = "0"
    }

    // adds the task to the database
    fun addTask() {
        viewModelScope.launch {
            val score = Score()
            score.taskName = playerName.value.toString()
            score.description = guessAttempts.value?.toInt() ?: 0
            dao.insert(score)
        }
    }

}