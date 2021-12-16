package com.granson.seniordeveloper.ui.retrofit.logic

import com.granson.seniordeveloper.data.ToDoObject
import com.granson.seniordeveloper.di.APIService
import com.granson.seniordeveloper.di.NonHiltRetroCall.Companion.api
import javax.inject.Inject

class TodoRepository @Inject constructor(
        private val apiServiceImpl: APIService
) {

    suspend fun getTodoList(): List<ToDoObject>? {
        return apiServiceImpl.getTodos().body()
    }

    suspend fun getTodoNonHilt(): List<ToDoObject>? {
        return api.getTodos().body()
    }

}