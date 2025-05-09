package com.daepcuatro.laboratorio05_pdm.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.daepcuatro.laboratorio05_pdm.ui.home.HomeScreen
import com.daepcuatro.laboratorio05_pdm.ui.todo.ToDoScreen
import com.daepcuatro.laboratorio05_pdm.ui.sensors.SensorLuzScreen

@Composable
fun NavigationScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("todo") {
            ToDoScreen()
        }
        composable("sensor") {
            SensorLuzScreen()
        }
    }
}
