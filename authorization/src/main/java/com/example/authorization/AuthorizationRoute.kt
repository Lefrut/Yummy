package com.example.authorization

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun AuthorizationRoute(navController: NavController) {
    val viewModel = hiltViewModel<AuthorizationViewModel>()
    val viewState by viewModel.collectAsState()

    AuthorizationScreen(viewModel = viewModel, viewState = viewState)

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            else -> {
            }
        }
    }
}