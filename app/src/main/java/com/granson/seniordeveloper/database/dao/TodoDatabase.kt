package com.granson.seniordeveloper.database.dao

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.granson.seniordeveloper.database.dbo.TodoDBO
import com.granson.seniordeveloper.database.interfaces.DaoService

@Database(
    entities = [TodoDBO::class],
    version = 1,
    exportSchema = false
)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun getTodo(): DaoService

    companion object {
        @Volatile
        private var instance: TodoDatabase? = null
        private val Lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(Lock) {
            instance ?: createDB(context).also { instance = it }
        }

        private fun createDB(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            TodoDatabase::class.java,
            "todo_db.db"
        ).build()
    }

}