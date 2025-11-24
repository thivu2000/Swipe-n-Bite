package com.example.snacknbite.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SwipeIndicators(offsetX: Float, threshold: Float = 150f) {
    when {
        offsetX > threshold -> {
            Text(
                text = "✅",
                fontSize = 40.sp,
                color = Color.Green,
                modifier = Modifier.padding(16.dp)
            )
        }
        offsetX < -threshold -> {
            Text(
                text = "❌",
                fontSize = 40.sp,
                color = Color.Red,
                modifier = Modifier.padding(16.dp)
            )
        }
        else -> {
        }
    }
}
