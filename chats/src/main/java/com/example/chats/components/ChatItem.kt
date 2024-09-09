package com.example.chats.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.theme.AppColors
import com.example.ui.theme.AppFonts
import com.example.ui.theme.MangoChatTheme

@Composable
fun ChatItem(name: String, onClick: () -> Unit) {
    Column(modifier = Modifier.clickable { onClick() }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                tint = AppColors.onPrimary,
                modifier = Modifier.size(60.dp),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = name,
                color = AppColors.onPrimary,
                style = AppFonts.bodyLarge
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(AppColors.onPrimary)
        )
    }
}

@Preview
@Composable
private fun ChatItemPreview() {
    MangoChatTheme {
        ChatItem("Alex"){}
    }
}