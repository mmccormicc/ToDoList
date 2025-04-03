package com.example.todolist

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class ToDoItemRepository(private val ToDoItemDao: ToDoItemDao) {

    val allToDoItems: Flow<List<ToDoItem>> = ToDoItemDao.allToDoItems()

    @WorkerThread
    suspend fun insertToDoItem(toDoItem: ToDoItem) {
        ToDoItemDao.insertToDoItem(toDoItem)
    }

    @WorkerThread
    suspend fun updateToDoItem(toDoItem: ToDoItem) {
        ToDoItemDao.updateToDoItem(toDoItem)
    }

    @WorkerThread
    suspend fun deleteToDoItem(toDoItem: ToDoItem) {
        ToDoItemDao.deleteToDoItem(toDoItem)
    }
}