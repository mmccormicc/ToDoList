package com.example.todolist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Creating table
@Entity(tableName = "todo_table")
class ToDoItem(
    // Creating column for title of ToDoItem
    @ColumnInfo(name = "title") var title : String,
    // Creating column that holds if ToDoItem is completed or not
    @ColumnInfo(name = "checked") var checked : Boolean,
    // Used to identify ToDoItem entries
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
