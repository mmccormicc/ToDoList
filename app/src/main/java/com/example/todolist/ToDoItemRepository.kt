package com.example.todolist

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class ToDoItemRepository(private val ToDoItemDao: ToDoItemDao) {
    // Getting flow from DAO
    val allToDoItems: Flow<List<ToDoItem>> = ToDoItemDao.allToDoItems()

    // Thread for inserting item
    @WorkerThread
    suspend fun insertToDoItem(toDoItem: ToDoItem) {
        ToDoItemDao.insertToDoItem(toDoItem)
    }

    // Thread for updating item
    @WorkerThread
    suspend fun updateToDoItem(toDoItem: ToDoItem) {
        ToDoItemDao.updateToDoItem(toDoItem)
    }

    // Thread for deleting item
    @WorkerThread
    suspend fun deleteToDoItem(toDoItem: ToDoItem) {
        ToDoItemDao.deleteToDoItem(toDoItem)
    }
}