package com.daepcuatro.laboratorio05_pdm.ViewModel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.daepcuatro.laboratorio05_pdm.model.Task

class TaskViewModel : ViewModel() {
    var tasks by mutableStateOf(listOf<Task>())
        private set

    var taskTitle by mutableStateOf("")
    var taskDescription by mutableStateOf("")

    fun addTask() {
        if (taskTitle.isNotBlank()) {
            val newTask = Task(
                id = tasks.size + 1,
                title = taskTitle,
                description = taskDescription
            )
            tasks = tasks + newTask
            taskTitle = ""
            taskDescription = ""
        }
    }

    fun deleteTask(task: Task) {
        tasks = tasks.filter { it.id != task.id }
    }

    fun toggleTaskCompletion(task: Task) {
        tasks = tasks.map {
            if (it.id == task.id) it.copy(isCompleted = !it.isCompleted) else it
        }
    }

    fun clearAllTasks() {
        tasks = listOf()
    }
}
