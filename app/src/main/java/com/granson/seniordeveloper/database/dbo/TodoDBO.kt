package com.granson.seniordeveloper.database.dbo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Todo"
)
data class TodoDBO(
    @PrimaryKey(autoGenerate = true)
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)