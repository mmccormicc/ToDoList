package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.todolist.ui.theme.ToDoListTheme

class MainActivity : AppCompatActivity() {
    // Initializing view model
    private val toDoViewModel: ToDoViewModel by viewModels {
        ToDoItemModelFactory((application as ToDoApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ToDoListPage(
                        modifier = Modifier.padding(innerPadding),
                        activity = this
                    )
                }
            }
        }
    }
}
