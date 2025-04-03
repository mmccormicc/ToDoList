package com.example.todolist;

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ToDoViewModel(private val repository: ToDoItemRepository): ViewModel() {
    var toDoItems: LiveData<List<ToDoItem>> = repository.allToDoItems.asLiveData()

    fun addToDoItem(newToDoItem : ToDoItem) = viewModelScope.launch {
        repository.insertToDoItem(newToDoItem)
    }

    fun updateToDoItem(toDoItem: ToDoItem) = viewModelScope.launch {
        repository.updateToDoItem(toDoItem)
    }

    fun deleteToDoItem(toDoItem: ToDoItem) = viewModelScope.launch {
        repository.deleteToDoItem(toDoItem)
    }

}

class ToDoItemModelFactory(private val repository: ToDoItemRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ToDoViewModel::class.java))
            return ToDoViewModel(repository) as T
        throw IllegalArgumentException("Unknown View Model Class")
    }
}