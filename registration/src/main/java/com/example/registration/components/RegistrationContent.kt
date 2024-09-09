package com.example.registration.components;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.registration.RegistrationViewModel
import com.example.registration.model.RegistrationState
import com.example.resources.R
import com.example.ui.buttons.PrimaryButton
import com.example.ui.textfields.countryCodePickerColors
import com.example.ui.textfields.mangoColors
import com.example.ui.theme.AppColors
import com.example.ui.theme.AppFonts
import com.example.ui.theme.AppShapes
import com.joelkanyi.jcomposecountrycodepicker.component.KomposeCountryCodePicker
import com.joelkanyi.jcomposecountrycodepicker.component.rememberKomposeCountryCodePickerState

@Composable
fun RegistrationContent(
    modifier: Modifier = Modifier,
    viewModel: RegistrationViewModel,
    viewState: RegistrationState
) {
    Column(
        modifier = modifier.padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(14.dp, Alignment.CenterVertically)
    ) {
        OutlinedTextField(
            value = viewState.phoneNumber,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.mangoColors(),
            label = {
                Text(
                    text = stringResource(R.string.phone_number),
                    style = AppFonts.labelMedium
                )
            },
            textStyle = AppFonts.bodyMedium,
            shape = AppShapes.medium,
            maxLines = 1,
        )

        OutlinedTextField(
            value = viewState.name,
            onValueChange = viewModel::changeName,
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.mangoColors(),
            label = {
                Text(
                    text = stringResource(R.string.name),
                    style = AppFonts.labelMedium
                )
            },
            textStyle = AppFonts.bodyMedium,
            shape = AppShapes.medium,
            maxLines = 1
        )

        OutlinedTextField(
            value = viewState.username,
            onValueChange = viewModel::changeUsername,
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.mangoColors(),
            label = {
                Text(
                    text = stringResource(R.string.username),
                    style = AppFonts.labelMedium
                )
            },
            textStyle = AppFonts.bodyMedium,
            shape = AppShapes.medium,
            maxLines = 1
        )

        PrimaryButton(
            modifier = Modifier.padding(top = 20.dp),
            text = stringResource(R.string._continue_),
            onClick = viewModel::register
        )
    }
}