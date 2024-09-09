package com.example.registration.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.resources.R
import com.example.ui.theme.AppColors
import com.example.ui.theme.AppFonts

@Composable
fun RegistrationTopBar(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.registration),
        modifier = modifier
            .fillMaxWidth()
            .padding(18.dp)
            .wrapContentWidth(Alignment.CenterHorizontally),
        color = AppColors.onPrimary,
        style = AppFonts.titleMedium
    )
}