package com.example.chats.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.resources.R
import com.example.ui.theme.AppColors
import com.example.ui.theme.AppFonts
import com.example.ui.theme.MangoChatTheme

@Composable
fun ChatsTopBar(modifier: Modifier = Modifier, onProfileClick: () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.chats),
            color = AppColors.onPrimary,
            style = AppFonts.titleMedium
        )
        Icon(
            imageVector = Icons.Default.AccountBox,
            tint = AppColors.onPrimary,
            contentDescription = null,
            modifier = Modifier
                .size(
                    32.dp
                )
                .clickable { onProfileClick() }
        )
    }
}

@Preview
@Composable
private fun ChatsTopBarPreview() {
    MangoChatTheme {
        ChatsTopBar {  }
    }
}