package com.example.todolist;

import androidx.room.*;

import kotlinx.coroutines.flow.Flow;

@Dao
interface ToDoItemDao {
    // Retrieving all items from table of toDoItems
    @Query("SELECT * FROM todo_table")
    fun allToDoItems(): Flow<List<ToDoItem>>

    // Inserting into table
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDoItem(toDoItem : ToDoItem)

    // Updating table entry
    @Update
    suspend fun updateToDoItem(toDoItem : ToDoItem)

    // Deleting table entry
    @Delete
    suspend fun deleteToDoItem(toDoItem : ToDoItem)
}