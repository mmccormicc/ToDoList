package com.example.todolist

data class ToDo(
    var id: Int,
    var title : String
)

fun getTestTodo() : List<ToDo> {
    return listOf<ToDo>(
        ToDo(1, "1 Rake leaves"),
        ToDo(2, "2 Get haircut"),
        ToDo(3, "3 Make dinner")
    )
}
