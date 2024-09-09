package com.example.chats;

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.chats.model.ChatsEffect
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun ChatsRoute(navController: NavController) {
    val viewModel = hiltViewModel<ChatsViewModel>()
    val viewState by viewModel.collectAsState()

    ChatsScreen(viewModel = viewModel, viewState = viewState)

    viewModel.collectSideEffect { effect ->
        when (effect) {
            is ChatsEffect.NavigateToChat -> {
                //todo
                navController.navigate("")
            }
        }
    }

}