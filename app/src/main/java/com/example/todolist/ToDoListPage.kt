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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp;
import androidx.compose.ui.unit.sp


@Composable
fun ToDoListPage(modifier: Modifier = Modifier, toDoViewModel: ToDoViewModel, toDoItemList : List<ToDoItem>) {

    // Holds text of box used to add to-do
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
                    val newToDo = ToDoItem(inputText, false)
                    // Calling add item function in view model
                    toDoViewModel.addToDoItem(newToDo)
                    // Reset add to-do box
                    inputText = ""
                },
                // Setting add button to blue
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                // Text for add button
                Text(
                    text = "Add",
                    color = Color.White,
                    fontSize = 24.sp
                )
            }
        }

        // Lazy column for displaying toDoItemList
        LazyColumn(
            // Filling entire height
            modifier = Modifier.fillMaxHeight()
        ) {
                // Creating toDoItem entry for each item in list
                itemsIndexed(toDoItemList) { index, item ->
                    ToDoItem(item = item, toDoViewModel = toDoViewModel)
                }
        }
    }
}

// Composable for todoItem
@Composable
fun ToDoItem(item : ToDoItem, toDoViewModel: ToDoViewModel) {
    // Holds if checkbox in ui element is checked or not
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
            // Calling delete function from view model
            onClick = { toDoViewModel.deleteToDoItem(item) },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            // Delete button text
            Text(
                text = "Delete",
                color = Color.White,
                fontSize = 16.sp
            )
        }
        // Checkbox for to-do completion
        Checkbox(
            checked = checked,
            colors = CheckboxDefaults.colors(checkedColor = Color.Blue, uncheckedColor = Color.White),
            onCheckedChange = {
                // Updating checked status when clicked
                item.checked = it
                checked = it
                // Updating todoItem to mark as checked
                toDoViewModel.updateToDoItem(item)
            }
        )
    }
}
