package com.example.todolist

import android.app.Application

class ToDoApplication: Application() {
    private val database by lazy { ToDoItemDatabase.getDatabase(this)}
    val repository by lazy { ToDoItemRepository(database.toDoItemDao())}
}