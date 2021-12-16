package com.granson.seniordeveloper.ui

import androidx.lifecycle.ViewModel
import com.granson.seniordeveloper.di.NetworkModule
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @NetworkModule.ThirdString string: String
): ViewModel() {
    private var string1: String = ""

    init {
        string1 = string
    }

    suspend fun returnDelayedVal(): String {
        for (i in 1..10){
            delay(2000)
            println("---> $i")
        }

        return string1
    }

}