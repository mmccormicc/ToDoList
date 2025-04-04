package com.example.todolist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Initializing database
@Database(entities = [ToDoItem::class], version = 1, exportSchema = false)
abstract class ToDoItemDatabase: RoomDatabase() {
    abstract fun toDoItemDao(): ToDoItemDao

    // Can be accessed from other classes, similar to static in java
    companion object {
        // Instance of database
        @Volatile
        private var INSTANCE: ToDoItemDatabase? = null

        fun getDatabase(context: Context): ToDoItemDatabase{
            return INSTANCE ?: synchronized(this) {
                // Building room
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