package com.example.authorization

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui.theme.MangoChatTheme
import com.joelkanyi.jcomposecountrycodepicker.component.KomposeCountryCodePicker
import com.joelkanyi.jcomposecountrycodepicker.component.rememberKomposeCountryCodePickerState

@Composable
fun AuthorizationScreen() {
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    val state = rememberKomposeCountryCodePickerState(
        showCountryCode = true,
        showCountryFlag = true,
        defaultCountryCode = "KE",
    )

    KomposeCountryCodePicker(
        state = state,
        modifier = Modifier.fillMaxWidth(),
        text = phoneNumber,
        onValueChange = {
            phoneNumber = it
        },
    )

}

@Preview
@Composable
private fun AuthorizationScreenPreview() {
    MangoChatTheme {
        AuthorizationScreen()
    }
}