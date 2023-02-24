package com.example.rfid_reader

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.rfid_reader.RfidDestinations.HOME_ROUTE
import com.example.rfid_reader.RfidScreens.HOME_SCREEN
import com.example.rfid_reader.RfidScreens.LOGIN_SCREEN

private object RfidScreens {
    const val LOGIN_SCREEN = "login"
    const val HOME_SCREEN = "home"
}

object RfidDestinations {
    const val LOGIN_ROUTE = LOGIN_SCREEN
    const val HOME_ROUTE = HOME_SCREEN
}

class RfidNavigationActions(private val navController: NavHostController) {
    fun navigateToHome() {
        navController.navigate(HOME_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                inclusive = true
            }
        }
    }
}