package com.example.todolist;

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ToDoViewModel(private val repository: ToDoItemRepository): ViewModel() {

    // Getting livedata from repository
    var toDoItems: LiveData<List<ToDoItem>> = repository.allToDoItems.asLiveData()

    // Add item with repository
    fun addToDoItem(newToDoItem : ToDoItem) = viewModelScope.launch {
        repository.insertToDoItem(newToDoItem)
    }

    // Update item with repository
    fun updateToDoItem(toDoItem: ToDoItem) = viewModelScope.launch {
        repository.updateToDoItem(toDoItem)
    }

    // Delete item with repository
    fun deleteToDoItem(toDoItem: ToDoItem) = viewModelScope.launch {
        repository.deleteToDoItem(toDoItem)
    }

}

// Factory for view model
class ToDoItemModelFactory(private val repository: ToDoItemRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ToDoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ToDoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}