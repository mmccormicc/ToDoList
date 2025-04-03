package com.example.todolist

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "todo_table")
class ToDo(
    @ColumnInfo(name = "id") var title : String,
    @ColumnInfo(name = "id") var checked : Boolean
)
