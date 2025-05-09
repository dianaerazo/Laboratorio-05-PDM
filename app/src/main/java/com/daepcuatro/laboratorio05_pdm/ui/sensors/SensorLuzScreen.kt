package com.daepcuatro.laboratorio05_pdm.ui.sensors

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SensorLuzScreen(viewModel: SensorLuzViewModel = viewModel()) {
    val light by viewModel.lightLevel

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Nivel de luz ambiental:")
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "$light lux",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}
