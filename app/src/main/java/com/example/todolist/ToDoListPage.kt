package com.example.todolist

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp;

@Composable
fun ToDoListPage(modifier: Modifier = Modifier) {

    val toDoList = getTestTodo()

    LazyColumn(
        modifier = Modifier.fillMaxHeight().padding(24.dp)
    ) {
        itemsIndexed(toDoList) { index, item ->
            Text("Item at index $index is $item")
        }
    }

}
