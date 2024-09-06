package com.example.ui.theme

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowInsetsControllerCompat

@Composable
fun MangoChatTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalColors provides MangoChatColors(),
        LocalShapes provides MangoChatShapes(),
        LocalFonts provides MangoChatFonts()

    ) {
        SetSystemBarsColorsEffect(
            statusBarColor = AppColors.background,
            navigationBarColor = AppColors.background
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.systemBars)
                .background(color = AppColors.background)
        ) {
            content()
        }
    }
}

@Composable
fun SetSystemBarsColorsEffect(
    statusBarColor: Color,
    navigationBarColor: Color,
    isStatusBarDarkIcons: Boolean = false,
    isNavigationBarDarkIcons: Boolean = false
) {
    val view = LocalView.current
    SideEffect {
        val window = (view.context as? ComponentActivity)?.window ?: return@SideEffect

        WindowInsetsControllerCompat(window, view).let { controller ->
            controller.isAppearanceLightStatusBars = isStatusBarDarkIcons
            controller.isAppearanceLightNavigationBars = isNavigationBarDarkIcons
            window.statusBarColor = statusBarColor.toArgb()
            window.navigationBarColor =
                navigationBarColor.toArgb()
        }
    }
}


val LocalColors = staticCompositionLocalOf<MangoChatColors> {
    error("no mango chat colors")
}

val LocalShapes = staticCompositionLocalOf<MangoChatShapes> {
    error("no mango chat shapes")
}

val LocalFonts = staticCompositionLocalOf<MangoChatFonts> {
    error("no mango chat fonts")
}

val AppColors @Composable get() = LocalColors.current
val AppShapes @Composable get() = LocalShapes.current
val AppFonts @Composable get() = LocalFonts.current


