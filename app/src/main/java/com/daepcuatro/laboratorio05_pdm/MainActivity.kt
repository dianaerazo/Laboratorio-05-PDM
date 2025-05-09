package com.daepcuatro.laboratorio05_pdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.daepcuatro.laboratorio05_pdm.ui.navigation.NavigationScreen
import com.daepcuatro.laboratorio05_pdm.ui.theme.Laboratorio05_pdmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio05_pdmTheme {
                NavigationScreen()
            }
        }
    }
}
