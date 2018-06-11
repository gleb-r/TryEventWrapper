package com.example.radgl.tryeventwrapper.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _navigateToDetails = MutableLiveData<EventWrapper<String>>()

    val navigateToDetails: LiveData<EventWrapper<String>>
    get() = _navigateToDetails

    fun userClicksButton(itemId:String) {
        _navigateToDetails.value = EventWrapper(itemId)
    }
}



