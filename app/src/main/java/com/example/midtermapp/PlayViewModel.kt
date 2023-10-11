package com.example.midtermapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class PlayViewModel(val dao: ScoreDao) : ViewModel() {

    val guessAttempts: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val playerName: MutableLiveData<String> by lazy {
        MutableLiveData<String>("anonymous")
    }

    init {
        guessAttempts.value = "0"
    }

    fun addTask() {
        viewModelScope.launch {
            val task = Task()
            task.taskName = playerName.value.toString()
            task.description = guessAttempts.value?.toInt() ?: 0
            dao.insert(task)
        }
    }

}