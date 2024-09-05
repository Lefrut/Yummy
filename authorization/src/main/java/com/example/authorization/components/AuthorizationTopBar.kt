package com.example.authorization.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.authorization.model.AuthorizationStage
import com.example.resources.R
import com.example.ui.theme.AppColors
import com.example.ui.theme.AppFonts

@Composable
fun AuthorizationTopBar(modifier: Modifier = Modifier, authStage: AuthorizationStage) {
    Text(
        text = when (authStage) {
            AuthorizationStage.Phone -> stringResource(R.string.authorization).uppercase()
            AuthorizationStage.Code -> stringResource(R.string.enter_code).uppercase()
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(18.dp)
            .wrapContentWidth(Alignment.CenterHorizontally),
        color = AppColors.onPrimary,
        style = AppFonts.titleMedium
    )
}