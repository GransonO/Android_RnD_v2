package com.granson.seniordeveloper.di

import com.granson.seniordeveloper.data.ToDoObject
import retrofit2.Response
import retrofit2.http.GET


interface APIService {

    @GET("/todos")
    suspend fun getTodos(): Response<List<ToDoObject>>
}