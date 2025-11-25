package com.example.snacknbite.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp

@Composable
fun CompletionScreen(
    likedCount: Int,
    dislikedCount: Int,
    onRestart: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Titel
        BasicText(
            text = "Fertig!",
            style = TextStyle(
                fontSize = 28.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color(0xFF6200EE),
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Likes / Dislikes
        BasicText(
            text = "Likes: $likedCount",
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black
            )
        )
        BasicText(
            text = "Dislikes: $dislikedCount",
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Eigener Button (ohne Material)
        Box(
            modifier = Modifier
                .background(color = Color(0xFF03DAC6), shape = RoundedCornerShape(8.dp))
                .clickable { onRestart() }
                .padding(horizontal = 24.dp, vertical = 12.dp)
        ) {
            BasicText(
                text = "Neu starten",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}
