package com.example.profile;

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.profile.components.ProfileContent
import com.example.profile.components.ProfileTopBar
import com.example.profile.model.ProfileState
import com.example.ui.theme.AppColors

@Composable
fun ProfileScreen(viewModel: ProfileViewModel, viewState: ProfileState) {
    Scaffold(
        containerColor = AppColors.background,
        topBar = {
            ProfileTopBar()
        }
    ) { paddingValues ->
        ProfileContent(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            viewModel = viewModel,
            viewState = viewState
        )
    }
}
