package com.example.chat;

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun ChatRoute(navController: NavController) {
    val viewModel = hiltViewModel<ChatViewModel>()
    val viewState by viewModel.collectAsState()
    ChatScreen(viewModel = viewModel, viewState = viewState)

    viewModel.collectSideEffect {

    }
}