package com.example.todolist

import android.app.Application

class ToDoApplication: Application() {
    // Initializing database
    private val database by lazy { ToDoItemDatabase.getDatabase(this)}
    // Initializing repository
    val repository by lazy { ToDoItemRepository(database.toDoItemDao())}
}