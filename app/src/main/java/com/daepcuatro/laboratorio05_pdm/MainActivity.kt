package com.daepcuatro.laboratorio05_pdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.daepcuatro.laboratorio05_pdm.ui.theme.Laboratorio05_pdmTheme
import com.daepcuatro.laboratorio05_pdm.view.ToDoScreen
import com.daepcuatro.laboratorio05_pdm.ViewModel.TaskViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio05_pdmTheme {
                val taskViewModel: TaskViewModel = viewModel()
                ToDoScreen(viewModel = taskViewModel)
            }
        }
    }
}
