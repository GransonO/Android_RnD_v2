package com.granson.seniordeveloper.ui.retrofit.logic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {

    suspend fun getList() =  liveData {
        emit(todoRepository.getTodoList())
    }

    suspend fun getTodoNonHilt() =  liveData {
        emit(todoRepository.getTodoNonHilt())
    }

}