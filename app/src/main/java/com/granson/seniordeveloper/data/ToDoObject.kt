package com.granson.seniordeveloper.data


import com.google.gson.annotations.SerializedName

data class ToDoObject(
    @SerializedName("completed")
    val completed: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)