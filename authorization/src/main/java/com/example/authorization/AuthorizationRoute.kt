package com.example.authorization

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun AuthorizationRoute(navController: NavController) {
    val viewModel = hiltViewModel<AuthorizationViewModel>()

    AuthorizationScreen(viewModel = viewModel)

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            else -> {
            }
        }
    }
}