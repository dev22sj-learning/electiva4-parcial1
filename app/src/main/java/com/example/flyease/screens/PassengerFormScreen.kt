package com.example.flyease.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.flyease.model.ReservationData

@Composable
fun PassengerFormScreen(navController: NavController, onNext: (ReservationData) -> Unit) {
    var fullName by remember { mutableStateOf("") }
    var passport by remember { mutableStateOf("") }

    val isNameValid = fullName.isNotBlank()
    val isPassportValid = passport.length >= 8

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Datos del pasajero", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = { Text("Nombre completo") },
            isError = !isNameValid && fullName.isNotEmpty()
        )

        OutlinedTextField(
            value = passport,
            onValueChange = { passport = it },
            label = { Text("Número de pasaporte") },
            isError = !isPassportValid && passport.isNotEmpty()
        )

        Spacer(Modifier.height(24.dp))
        Button(
            onClick = {
                onNext(ReservationData(fullName, passport))
            },
            enabled = isNameValid && isPassportValid
        ) {
            Text("Siguiente")
        }
    }
}