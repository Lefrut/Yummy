package com.example.authorization.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.textfields.OTPTextField
import com.example.ui.theme.MangoChatTheme

@Composable
fun CodeContent(modifier: Modifier = Modifier, code: String, onCodeChange: (String) -> Unit) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OTPTextField(
            modifier = Modifier.padding(bottom = 80.dp).fillMaxWidth(0.8f),
            value = code,
            onValueChange = onCodeChange
        )
    }
}

@Preview
@Composable
private fun CodeContentPreview() {
    MangoChatTheme {
        CodeContent(code = "1234") {

        }
    }
}