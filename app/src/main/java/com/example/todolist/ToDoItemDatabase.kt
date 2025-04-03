package com.example.todolist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ToDoItem::class], version = 1, exportSchema = false)
abstract class ToDoItemDatabase: RoomDatabase() {
    abstract fun toDoItemDao(): ToDoItemDao

    companion object {
        @Volatile
        private var INSTANCE: ToDoItemDatabase? = null

        fun getDatabase(context: Context): ToDoItemDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ToDoItemDatabase::class.java,
                    "task_item_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}