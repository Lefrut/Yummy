package com.example.chats;

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chats.components.ChatsContent
import com.example.chats.components.ChatsTopBar
import com.example.chats.model.ChatsState
import com.example.ui.theme.AppColors

@Composable
fun ChatsScreen(viewModel: ChatsViewModel, viewState: ChatsState) {
    Scaffold(
        topBar = {
            ChatsTopBar()
        },
        containerColor = AppColors.background
    ) { paddingValues ->
        ChatsContent(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            viewModel = viewModel,
            viewState = viewState
        )
    }
}
