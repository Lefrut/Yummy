package com.example.ui.textfields

import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import com.example.ui.theme.AppColors


@Composable
fun OutlinedTextFieldDefaults.mangoColors() = colors(
    cursorColor = AppColors.onPrimary,
    focusedBorderColor = AppColors.primary,
    unfocusedBorderColor = AppColors.secondary,
    focusedContainerColor = AppColors.background,
    unfocusedContainerColor = AppColors.background,
    unfocusedLabelColor = AppColors.onPrimary,
    focusedLabelColor = AppColors.primary,
    unfocusedTextColor = AppColors.onPrimary,
    focusedTextColor = AppColors.onPrimary
)

@Composable
fun TextFieldDefaults.countryCodePickerColors() = colors(
    focusedTextColor = AppColors.onPrimary,
    unfocusedTextColor = AppColors.onPrimary,
    focusedIndicatorColor = AppColors.primary,
    unfocusedIndicatorColor = AppColors.secondary,
    unfocusedContainerColor = AppColors.background,
    focusedContainerColor = AppColors.background,
    focusedPlaceholderColor = AppColors.onPrimary.copy(alpha = 0.7f),
    unfocusedPlaceholderColor = AppColors.onPrimary.copy(alpha = 0.7f),
    cursorColor = AppColors.onPrimary
)