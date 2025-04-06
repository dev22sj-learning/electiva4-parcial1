package com.example.flyease

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flyease.model.ReservationData
import com.example.flyease.screens.FlightSelectionScreen
import com.example.flyease.screens.PassengerFormScreen
import com.example.flyease.screens.ReservationSummaryScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AppNavHost()
            }
        }
    }
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    var reservationData by remember { mutableStateOf(ReservationData()) }

    NavHost(navController, startDestination = "passenger_form") {
        composable("passenger_form") {
            PassengerFormScreen (navController) { data ->
                reservationData = reservationData.copy(
                    fullName = data.fullName,
                    passportNumber = data.passportNumber
                )
                navController.navigate("flight_selection")
            }
        }
        composable("flight_selection") {
            FlightSelectionScreen (navController) { destination, date ->
                reservationData = reservationData.copy(
                    destination = destination,
                    date = date
                )
                navController.navigate("reservation_summary")
            }
        }
        composable("reservation_summary") {
            ReservationSummaryScreen(reservationData)
        }
    }

}