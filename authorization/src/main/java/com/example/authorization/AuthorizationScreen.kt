package com.example.authorization

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.authorization.components.AuthorizationContent
import com.example.authorization.components.AuthorizationTopBar
import com.example.authorization.model.AuthorizationState

@Composable
fun AuthorizationScreen(
    viewModel: AuthorizationViewModel,
    viewState: AuthorizationState
) {
    Scaffold(
        topBar = { AuthorizationTopBar() },
        containerColor = Color.Transparent
    ) { paddingValues ->
        AuthorizationContent(
            modifier = Modifier.padding(paddingValues),
            onPhoneNumberChange = viewModel::changePhoneNumber,
            phoneNumber = viewState.phoneNumber
        )
    }
}