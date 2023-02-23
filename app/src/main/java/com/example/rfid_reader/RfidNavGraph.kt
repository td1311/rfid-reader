package com.example.rfid_reader

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.rfid_reader.ui.home.HomeScreen
import com.example.rfid_reader.ui.login.LoginScreen
import kotlinx.coroutines.CoroutineScope

@Composable
fun RfidNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    startDestination: String = RfidDestinations.LOGIN_ROUTE,
    navActions: RfidNavigationActions = remember(navController) {
        RfidNavigationActions(navController)
    }
) {
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: startDestination

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(RfidDestinations.LOGIN_ROUTE) {
            LoginScreen()
        }
        composable(RfidDestinations.HOME_ROUTE) {
            HomeScreen()
        }
    }
}