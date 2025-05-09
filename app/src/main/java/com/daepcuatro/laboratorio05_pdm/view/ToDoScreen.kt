package com.daepcuatro.laboratorio05_pdm.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.daepcuatro.laboratorio05_pdm.model.Task
import com.daepcuatro.laboratorio05_pdm.ViewModel.TaskViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoScreen(viewModel: TaskViewModel) {
    val tasks = viewModel.tasks
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Lista de Tareas") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Text("+")
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(tasks) { task ->
                    TaskCard(
                        task = task,
                        onToggleComplete = {
                            viewModel.toggleTaskCompletion(task)
                        },
                        onDelete = {
                            viewModel.deleteTask(task)
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar("Tarea eliminada")
                            }
                        }
                    )
                }
            }

            Button(onClick = { viewModel.clearAllTasks() }) {
                Text("Limpiar Lista")
            }
        }

        if (showDialog) {
            TaskDialog(
                title = viewModel.taskTitle,
                description = viewModel.taskDescription,
                onTitleChange = { viewModel.taskTitle = it },
                onDescriptionChange = { viewModel.taskDescription = it },
                onDismiss = { showDialog = false },
                onAddTask = {
                    viewModel.addTask()
                    showDialog = false
                }
            )
        }
    }
}