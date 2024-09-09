package com.example.chat.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.resources.R
import com.example.ui.theme.AppColors
import com.example.ui.theme.AppFonts

@Composable
fun ChatTopBar(name: String,modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
            .fillMaxWidth()
            .padding(18.dp)
            .wrapContentWidth(Alignment.CenterHorizontally),
        color = AppColors.onPrimary,
        style = AppFonts.titleMedium,
        maxLines = 1
    )
}