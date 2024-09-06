package com.example.ui.textfields

import androidx.annotation.IntRange
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillNode
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalAutofill
import androidx.compose.ui.platform.LocalAutofillTree
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ui.theme.AppColors
import com.example.ui.theme.AppFonts
import com.example.ui.theme.AppShapes

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OTPTextField(
    value: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    @IntRange(from = 4, to = 6) numDigits: Int = 6,
    textStyle: TextStyle = AppFonts.bodyLarge.copy(color = AppColors.onPrimary),
) {
    val focusManager = LocalFocusManager.current

    val autoFillNode = AutofillNode(
        autofillTypes = listOf(AutofillType.SmsOtpCode),
        onFill = onValueChange
    )
    val autoFill = LocalAutofill.current

    LocalAutofillTree.current += autoFillNode

    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .onGloballyPositioned {
                autoFillNode.boundingBox = it.boundsInWindow()
            }
            .onFocusChanged { focusState ->
                autoFill?.run {
                    if (focusState.isFocused) {
                        requestAutofillForNode(autoFillNode)
                    } else {
                        cancelAutofillForNode(autoFillNode)
                    }
                }
            },
        value = value,
        onValueChange = {
            if (it.length <= numDigits) {
                onValueChange(it)
            }
            if (it.length >= numDigits) {
                focusManager.clearFocus()
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = ImeAction.Done
        ),
        decorationBox = { _ ->
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                repeat(numDigits) { index ->
                    val char = when {
                        index >= value.length -> ""
                        else -> value[index].toString()
                    }
                    val isFocused = value.length == index
                    Spacer(modifier = Modifier.weight(0.16f))
                    OutlinedDigitContainer(
                        isFocused = isFocused,
                        digit = char,
                        textStyle = textStyle,
                    )
                }
                Spacer(modifier = Modifier.weight(0.16f))
            }

        }
    )
}


@Composable
private fun RowScope.OutlinedDigitContainer(
    isFocused: Boolean,
    digit: String,
    textStyle: TextStyle,
) {

    val animatedColor by animateColorAsState(
        targetValue = if (isFocused) AppColors.primary else AppColors.secondary,
        label = "border color",
        animationSpec = tween(durationMillis = 100)
    )

    val animatedBorderWidth by animateDpAsState(
        targetValue = if (isFocused) 3.dp else 2.dp,
        label = "border width",
        animationSpec = tween(durationMillis = 100)
    )

    Box(
        modifier = Modifier
            .weight(1f)
            .aspectRatio(0.8f)
            .clip(AppShapes.small)
            .border(
                width = animatedBorderWidth,
                color = animatedColor,
                shape = AppShapes.small
            )
            .background(
                color = AppColors.background,
                shape = AppShapes.small
            )
            .padding(2.dp),
        contentAlignment = Alignment.Center
    ) {
        if (digit.isBlank()) {
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(AppColors.onPrimary)
            )
        } else {
            Text(
                text = digit,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(bottom = 0.dp)
                    .wrapContentHeight(),
                style = textStyle,
                textAlign = TextAlign.Center,
                maxLines = 1,
            )
        }
    }
}


