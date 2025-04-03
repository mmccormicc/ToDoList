package com.example.todolist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
class ToDoItem(
    @ColumnInfo(name = "title") var title : String,
    @ColumnInfo(name = "checked") var checked : Boolean,
    //@PrimaryKey(autoGenerate = true) var id: Int = 0
)
