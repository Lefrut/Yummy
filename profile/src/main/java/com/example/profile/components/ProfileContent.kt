package com.example.profile.components;

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.profile.ProfileViewModel
import com.example.profile.model.ProfileState
import com.example.ui.theme.AppColors
import com.example.ui.theme.AppFonts

@Composable
fun ProfileContent(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel,
    viewState: ProfileState
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(20.dp),
            text = viewState.username,
            color = AppColors.onPrimary,
            style = AppFonts.titleMedium
        )
    }
}