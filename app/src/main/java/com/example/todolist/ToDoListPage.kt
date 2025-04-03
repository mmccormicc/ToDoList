package com.example.todolist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp;
import androidx.compose.ui.unit.sp


@Composable
fun ToDoListPage(modifier: Modifier = Modifier) {

    val toDoList = remember { mutableStateListOf(ToDo("1 Rake leaves", false),
        ToDo("2 Get haircut", true),
        ToDo("3 Make dinner", false))}

    var inputText by remember { mutableStateOf("")}

    // Base column that uses inner padding
    Column(
        modifier = modifier
    ) {

        // Row to add items
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            // Text field to add task title
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = inputText,
                onValueChange = {
                    inputText = it
                }
            )
            // Add task button
            Button(
                modifier = Modifier.padding(8.dp),
                // When clicked
                onClick = {
                    // Update list with new to do
                    toDoList.add(ToDo(inputText, false))
                    // Reset add task box
                    inputText = ""
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text(
                    text = "Add",
                    color = Color.White,
                    fontSize = 24.sp
                )
            }
        }

        // Lazy column for displaying todolist items
        LazyColumn(
            // Filling entire height
            modifier = Modifier.fillMaxHeight()
        ) {
            // Creating todoItem for each item in list
            itemsIndexed(toDoList) { index, item ->
                ToDoItem(item = item, toDoList = toDoList)
            }
        }
    }
}

@Composable
fun ToDoItem(item : ToDo, toDoList: MutableList<ToDo>) {

    var checked by remember { mutableStateOf(item.checked)}

    // Creating row for each toDoItem
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RectangleShape)
            .background(MaterialTheme.colorScheme.primary)
    ) {
        // Text that holds item title
        Text(
            modifier = Modifier.weight(1f),
            text = item.title,
            color = Color.White,
            fontSize = 30.sp
        )
        // Delete button
        Button(
            onClick = { toDoList.remove(item) },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(
                text = "Delete",
                color = Color.White,
                fontSize = 16.sp
            )
        }
        // Checkbox for completion
        Checkbox(
            checked = checked,
            colors = CheckboxDefaults.colors(checkedColor = Color.Blue, uncheckedColor = Color.White),
            onCheckedChange = {
                item.checked = it
                checked = it
                println(item.checked)
            }
        )
    }
}
