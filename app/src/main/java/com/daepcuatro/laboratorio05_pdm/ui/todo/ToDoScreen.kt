package com.daepcuatro.laboratorio05_pdm.ui.todo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.daepcuatro.laboratorio05_pdm.models.Card
import com.daepcuatro.laboratorio05_pdm.ui.components.Cards
import com.daepcuatro.laboratorio05_pdm.ui.theme.Laboratorio05_pdmTheme
import java.util.Date

data class Tarea(val titulo: String, val descripcion: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoScreen(modifier: Modifier = Modifier) {
    val lista = remember { mutableStateListOf<Card>() }
    val openDialog = remember { mutableStateOf(false) }
    val newCard = remember { mutableStateOf(Card(0, "", "")) }
    val openDateDialog = remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    openDialog.value = true
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.Black,
                )
            }
        },
    ) {
        if (openDialog.value) {
            Dialog(
                properties = DialogProperties(
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true,
                ),

                onDismissRequest = { openDialog.value = false },
                content = {
                    Card {
                        Text(
                            text = "Agregar tarea",
                            style = MaterialTheme.typography.headlineSmall,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp),
                            textAlign = TextAlign.Center,
                        )
                        TextField(
                            value = newCard.value.title,
                            onValueChange = { newCard.value = newCard.value.copy(title = it) },
                            label = { Text("Title") },
                            placeholder = { Text("Title") },
                            modifier = Modifier.padding(16.dp),
                        )
                        TextField(
                            value = newCard.value.description,
                            onValueChange = {
                                newCard.value = newCard.value.copy(description = it)
                            },
                            label = { Text("Description") },
                            placeholder = { Text("Description") },
                            modifier = Modifier.padding(16.dp)
                        )
                        TextField(
                            value = newCard.value.endDate.toString(),
                            readOnly = true,
                            onValueChange = { },
                            label = { Text("Description") },
                            placeholder = { Text("Description") },
                            modifier = Modifier.padding(16.dp)
                        )
                        Button(
                            onClick = {
                                openDateDialog.value = true
                            },
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text("Select Date")
                        }
                        if (openDateDialog.value) {
                            val datePickerState =
                                rememberDatePickerState(initialSelectedDateMillis = Date().time)
                            DatePickerDialog(
                                onDismissRequest = {
                                    openDateDialog.value = false
                                },
                                confirmButton = {
                                    Button(onClick = {
                                        openDateDialog.value = false
                                        newCard.value = newCard.value.copy(
                                            endDate = datePickerState.selectedDateMillis?.let {
                                                Date(it)
                                            } ?: Date()
                                        )
                                    }) {
                                        Text("OK")
                                    }
                                },

                                ) {
                                DatePicker(state = datePickerState)
                            }
                        }
                        Button(
                            onClick = {
                                lista.add(newCard.value)
                                newCard.value = Card(0, "", "")
                                openDialog.value = false
                            },
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text("Add")
                        }
                    }
                }
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = it.calculateTopPadding() + 16.dp),
        ) {
            items(lista.size) { index ->
                val card = lista[index]
                Cards(
                    pos = index,
                    max = lista.size - 1,
                    title = card.title,
                    description = card.description,
                    delete = { pos ->
                        lista.removeAt(pos)
                    },
                    check = { checked, pos ->
                        lista[pos] = card.copy(checked = checked)
                    },
                    endDate = card.endDate,
                    checked = card.checked,
                    changePosition = { lastPos, newPos ->

                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Laboratorio05_pdmTheme {
        ToDoScreen()
    }
}