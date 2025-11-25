package com.example.snacknbite.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.text.BasicText

@Composable
fun SwipeIndicators(offsetX: Float, threshold: Float = 150f) {
    when {
        offsetX > threshold -> {
            BasicText(
                text = "✅",
                modifier = Modifier.padding(16.dp),
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 40.sp,
                    color = Color.Green
                )
            )
        }
        offsetX < -threshold -> {
            BasicText(
                text = "❌",
                modifier = Modifier.padding(16.dp),
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 40.sp,
                    color = Color.Red
                )
            )
        }
        else -> {
            // nichts anzeigen
        }
    }
}
