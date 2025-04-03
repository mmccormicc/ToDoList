package com.example.todolist;

import androidx.room.*;
//import androidx.room.Query;

import kotlinx.coroutines.flow.Flow;

@Dao
interface ToDoItemDao {
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun allToDoItems(): Flow<List<ToDoItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDoItem(toDoItem : ToDoItem)

    @Update
    suspend fun updateToDoItem(toDoItem : ToDoItem)

    @Delete
    suspend fun deleteToDoItem(toDoItem : ToDoItem)
}