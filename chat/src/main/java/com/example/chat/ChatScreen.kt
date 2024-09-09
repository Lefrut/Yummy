package com.example.chat;

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chat.components.ChatContent
import com.example.chat.components.ChatTopBar
import com.example.chat.model.ChatState
import com.example.ui.theme.AppColors

@Composable
fun ChatScreen(viewModel: ChatViewModel, viewState: ChatState) {
    Scaffold(
        topBar = { ChatTopBar(viewState.name) },
        containerColor = AppColors.background
    ) { paddingValues ->
        ChatContent(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            viewModel = viewModel,
            viewState = viewState
        )
    }
}
