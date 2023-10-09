package com.example.midtermapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlayViewModel : ViewModel() {

    val guessAttempts: MutableLiveData<String> by lazy {
        MutableLiveData<String>("0")
    }

    val playerName: MutableLiveData<String> by lazy {
        MutableLiveData<String>("default")
    }

}