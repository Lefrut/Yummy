package com.example.authorization

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ui.theme.AppFonts
import com.joelkanyi.jcomposecountrycodepicker.component.KomposeCountryCodePicker
import com.joelkanyi.jcomposecountrycodepicker.component.rememberKomposeCountryCodePickerState
import java.util.Locale

@Composable
fun AuthorizationContent(modifier: Modifier = Modifier) {
    val state = rememberKomposeCountryCodePickerState(
        showCountryCode = true,
        showCountryFlag = true,
        defaultCountryCode = Locale.getDefault().country,
    )

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        var phoneNumber by rememberSaveable { mutableStateOf("") }

        KomposeCountryCodePicker(
            state = state,
            modifier = Modifier.fillMaxWidth(),
            text = phoneNumber,
            onValueChange = { s ->
                phoneNumber = s
            },
            textStyle = AppFonts.bodyMedium
        )
    }
}