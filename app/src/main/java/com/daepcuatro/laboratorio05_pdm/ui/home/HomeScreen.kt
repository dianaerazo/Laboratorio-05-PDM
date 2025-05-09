package com.daepcuatro.laboratorio05_pdm.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Pantalla Home")

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.navigate("todo") }) {
            Text("Ir a ToDoList")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("sensor") }) {
            Text("Ir al Sensor de Luz")
        }
    }
}
