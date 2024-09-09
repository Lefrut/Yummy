package com.example.chats.components;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chats.ChatsViewModel
import com.example.chats.model.ChatsState
import com.example.ui.theme.AppColors
import com.example.ui.theme.MangoChatTheme

@Composable
fun ChatsContent(
    modifier: Modifier = Modifier,
    viewModel: ChatsViewModel,
    viewState: ChatsState
) {
    LazyColumn(
        modifier = modifier.padding(top = 1.dp).fillMaxSize(),
        contentPadding = PaddingValues(bottom = 30.dp)
    ) {
        item {
            Spacer(modifier = Modifier.fillMaxWidth().height(1.dp).background(AppColors.onPrimary))
        }
        items(viewState.chatNames) { name ->
            ChatItem(name) {
                viewModel.navigateToChat(name)
            }
        }
    }
}

@Preview
@Composable
private fun ChatsContentPreview() {
    MangoChatTheme {
        ChatsContent(modifier = Modifier.fillMaxSize(), ChatsViewModel(), ChatsState())
    }
}