package com.example.snacknbite.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object AppColors {
    val Primary = Color(0xFF6200EE)       // Lila
    val PrimaryDark = Color(0xFF3700B3)   // Dunkleres Lila
    val Secondary = Color(0xFF03DAC6)     // Türkis
    val Background = Color(0xFFFFFFFF)    // Weiß
    val Surface = Color(0xFFFFFFFF)       // Weiß
    val TextPrimary = Color.Black
    val TextOnPrimary = Color.White
}

@Composable
fun SnackNBiteTheme(content: @Composable () -> Unit) {
    content()
}
