package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.todolist.ui.theme.ToDoListTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initializing viewModelFactory by passing application repository
        val viewModelFactory = ToDoItemModelFactory((application as ToDoApplication).repository)
        // Initializing app view model with factory
        val toDoViewModel: ToDoViewModel by viewModels() {
            viewModelFactory
        }

        enableEdgeToEdge()
        setContent {
            ToDoListTheme {
                // Observing all toDoItems from view model and converting to List of toDoItem
                val toDoItemList: List<ToDoItem> by toDoViewModel.toDoItems.observeAsState(initial = emptyList())

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Calling composable for toDolist page of app
                    ToDoListPage(
                        modifier = Modifier.padding(innerPadding),
                        // Passing view model and list of todoitems
                        toDoViewModel = toDoViewModel,
                        toDoItemList = toDoItemList
                    )
                }
            }
        }
    }
}
