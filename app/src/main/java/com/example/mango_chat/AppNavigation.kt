package com.example.mango_chat

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.authorization.AuthorizationRoute
import com.example.navigation.NavScreen
import com.example.registration.RegistrationRoute

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavScreen.Authorization.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(NavScreen.Authorization.route) { AuthorizationRoute(navController) }
        composable(NavScreen.Registration.route) { RegistrationRoute(navController) }
    }
}