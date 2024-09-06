package com.example.registration;

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.registration.components.RegistrationContent
import com.example.registration.model.RegistrationState
import com.example.ui.theme.AppColors
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun RegistrationScreen(viewModel: RegistrationViewModel, viewState: RegistrationState) {
    Scaffold(
        containerColor = AppColors.background
    ) { paddingValues ->
        RegistrationContent(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            viewModel = viewModel,
            viewState = viewState
        )
    }
    viewModel.collectSideEffect {
        when (it) {
            else -> {}
        }
    }
}
