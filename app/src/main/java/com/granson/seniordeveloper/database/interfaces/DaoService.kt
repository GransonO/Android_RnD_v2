package com.granson.seniordeveloper.database.interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.granson.seniordeveloper.data.ToDoObject

@Dao
interface DaoService {

    @Insert(onConflict = REPLACE)
    suspend fun addTodo(todo: ToDoObject): Long

    @Query("SELECT * FROM Todo")
    fun getAllTodo(): LiveData<List<ToDoObject>>

    @Delete
    suspend fun deleteTodo(todo: ToDoObject)
}