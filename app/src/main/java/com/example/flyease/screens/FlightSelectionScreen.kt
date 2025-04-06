package com.example.flyease.screens

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.util.Calendar

@Composable
fun FlightSelectionScreen(navController: NavController, onReserve: (String, String) -> Unit) {
    val destinations = listOf("París", "Nueva York", "Tokio")
    var selectedDestination by remember { mutableStateOf(destinations.first()) }
    var expanded by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val datePicker = remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Selecciona tu destino y fecha", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = selectedDestination,
                onValueChange = {},
                label = { Text("Destino") },
                readOnly = true,
                trailingIcon = {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(enabled = false) {}
            )

            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clickable {
                        expanded = true
                    }
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                destinations.forEach { dest ->
                    DropdownMenuItem(
                        text = { Text(dest) },
                        onClick = {
                            selectedDestination = dest
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            val today = Calendar.getInstance()
            DatePickerDialog(context, { _, year, month, day ->
                datePicker.value = "$day/${month + 1}/$year"
            },
                today.get(Calendar.YEAR),
                today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH)
            ).show()
        }) {
            Text(if (datePicker.value.isEmpty()) "Seleccionar Fecha" else "Fecha: ${datePicker.value}")
        }

        Spacer(Modifier.height(24.dp))
        Button(
            onClick = {
                onReserve(selectedDestination, datePicker.value)
            },
            enabled = datePicker.value.isNotEmpty()
        ) {
            Text("Reservar Vuelo")
        }
    }
}