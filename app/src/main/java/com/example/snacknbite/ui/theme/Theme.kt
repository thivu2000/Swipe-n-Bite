package com.example.snacknbite.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = md_theme_primary,
    secondary = md_theme_secondary,
    background = md_theme_background,
    surface = md_theme_surface
)

@Composable
fun SnackNBiteTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
}
