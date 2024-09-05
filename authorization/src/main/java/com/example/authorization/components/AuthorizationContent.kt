package com.example.authorization.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.authorization.model.AuthorizationStage

@Composable
fun AuthorizationContent(
    modifier: Modifier = Modifier,
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit,
    onSendPhoneNumber: (String) -> Unit,
    authStage: AuthorizationStage,
    code: String, onCodeChange: (String) -> Unit
) {
    Box(modifier = modifier) {
        when (authStage) {
            AuthorizationStage.Phone -> {
                PhoneContent(
                    phoneNumber = phoneNumber,
                    onPhoneNumberChange = onPhoneNumberChange,
                    onSendPhoneNumber = onSendPhoneNumber
                )
            }

            AuthorizationStage.Code -> {
                CodeContent(
                    code = code,
                    onCodeChange =onCodeChange
                )
            }
        }
    }
}