package com.example.profile;

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun ProfileRoute(navController: NavController) {
    val viewModel = hiltViewModel<ProfileViewModel>()
    val viewState by  viewModel.collectAsState()
    ProfileScreen(viewModel = viewModel, viewState = viewState)
}