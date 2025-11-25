package com.example.snacknbite.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.BasicText   // << WICHTIG: ERSATZ FÜR TEXT

import com.example.snacknbite.data.model.FoodGenre
import com.example.snacknbite.ui.components.SwipeDeckWithButtons


@Composable
fun AppScaffold(foodList: List<FoodGenre>) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // 🔥 Titel oben zentriert
        BasicText(
            text = "Snack n' Bite",
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color(0xFF6200EE)
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        // 🔥 Dein Swipe Deck
        SwipeDeckWithButtons(
            foods = foodList,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}


@Composable
fun CustomButton(text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .background(Color(0xFF03DAC5), RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .padding(horizontal = 18.dp, vertical = 10.dp)
    ) {
        BasicText(
            text = text,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black
            )
        )
    }
}
