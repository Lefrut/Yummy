package com.example.registration;

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun RegistrationRoute(navController: NavController) {
    val viewModel = hiltViewModel<RegistrationViewModel>()
    val viewState by viewModel.collectAsState()
    RegistrationScreen(viewModel = viewModel, viewState = viewState)
}