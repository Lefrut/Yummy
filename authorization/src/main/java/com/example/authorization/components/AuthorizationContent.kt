package com.example.authorization.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.resources.R
import com.example.ui.theme.AppColors
import com.example.ui.theme.AppFonts
import com.joelkanyi.jcomposecountrycodepicker.component.KomposeCountryCodePicker
import com.joelkanyi.jcomposecountrycodepicker.component.rememberKomposeCountryCodePickerState
import java.util.Locale

@Composable
fun AuthorizationContent(
    modifier: Modifier = Modifier,
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit
) {
    val countryCodePickerState = rememberKomposeCountryCodePickerState(
        showCountryCode = true,
        showCountryFlag = true,
        defaultCountryCode = Locale.getDefault().country,
    )

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        KomposeCountryCodePicker(
            state = countryCodePickerState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
            text = phoneNumber,
            onValueChange = { s ->
                onPhoneNumberChange(s)
            },
            textStyle = AppFonts.bodyMedium.copy(color = AppColors.onPrimary),
            colors = TextFieldDefaults.colors(
                focusedTextColor = AppColors.onPrimary,
                unfocusedTextColor = AppColors.onPrimary,
                focusedIndicatorColor = AppColors.primary,
                unfocusedIndicatorColor = AppColors.secondary,
                unfocusedContainerColor = AppColors.background,
                focusedContainerColor = AppColors.background,
                focusedPlaceholderColor = AppColors.onPrimary.copy(alpha = 0.7f),
                unfocusedPlaceholderColor = AppColors.onPrimary.copy(alpha = 0.7f),
                cursorColor = AppColors.onPrimary
            ),
            countrySelectionDialogContentColor = AppColors.onPrimary,
            countrySelectionDialogContainerColor = AppColors.background,
            placeholder = {
                Text(
                    text = stringResource(R.string.phone_number),
                    style = AppFonts.labelMedium,
                )
            }
        )
        Spacer(Modifier.height(80.dp))
    }
}