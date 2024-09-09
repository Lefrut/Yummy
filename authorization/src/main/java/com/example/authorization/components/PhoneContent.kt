package com.example.authorization.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import com.example.resources.R
import com.example.ui.buttons.PrimaryButton
import com.example.ui.textfields.countryCodePickerColors
import com.example.ui.theme.AppColors
import com.example.ui.theme.AppFonts
import com.joelkanyi.jcomposecountrycodepicker.component.CountryCodePicker
import com.joelkanyi.jcomposecountrycodepicker.component.KomposeCountryCodePicker
import com.joelkanyi.jcomposecountrycodepicker.component.rememberKomposeCountryCodePickerState

@Composable
fun PhoneContent(
    modifier: Modifier = Modifier,
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit,
    countryCodePickerState: CountryCodePicker = rememberKomposeCountryCodePickerState(
        showCountryCode = true,
        showCountryFlag = true,
        defaultCountryCode = Locale.current.region,
    ),
    onSendPhoneNumber: (String) -> Unit,
) {
    val keyBoardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
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
            colors = TextFieldDefaults.countryCodePickerColors(),
            countrySelectionDialogContentColor = AppColors.onPrimary,
            countrySelectionDialogContainerColor = AppColors.background,
            placeholder = {
                Text(
                    text = stringResource(R.string.phone_number),
                    style = AppFonts.labelMedium,
                )
            }
        )

        PrimaryButton(
            text = stringResource(R.string.send),
            onClick = {
                keyBoardController?.hide()
                onSendPhoneNumber(countryCodePickerState.getCountryPhoneCode())
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .padding(horizontal = 25.dp)
        )
        Spacer(Modifier.height(80.dp))
    }

}