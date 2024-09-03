package com.example.authorization

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui.theme.MangoChatTheme
import com.joelkanyi.jcomposecountrycodepicker.component.KomposeCountryCodePicker
import com.joelkanyi.jcomposecountrycodepicker.component.rememberKomposeCountryCodePickerState

@Composable
fun AuthorizationScreen(
    viewModel: AuthorizationViewModel
) {
    Scaffold(
        topBar = {

        },
        containerColor = Color.Transparent
    ) { paddingValues ->
        AuthorizationContent(modifier = Modifier.padding(paddingValues))
    }
}

@Preview
@Composable
private fun AuthorizationScreenPreview() {
    MangoChatTheme {
        AuthorizationScreen(AuthorizationViewModel())
    }
}