package com.example.midtermapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume




class PlayViewModel(val dao: TaskDao) : ViewModel() {

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
            task.description = guessAttempts.value.toString()
            dao.insert(task)
        }
    }

}