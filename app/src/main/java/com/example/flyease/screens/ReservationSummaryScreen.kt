package com.example.flyease.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flyease.model.ReservationData

@Composable
fun ReservationSummaryScreen(data: ReservationData) {
    Column (
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Resumen de tu Reserva", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))
        Text("Nombre: ${data.fullName}")
        Text("Pasaporte: ${data.passportNumber}")
        Text("Destino: ${data.destination}")
        Text("Fecha: ${data.date}")
    }
}