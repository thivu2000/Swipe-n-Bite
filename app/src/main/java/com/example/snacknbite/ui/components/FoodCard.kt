package com.example.snacknbite.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.foundation.BorderStroke
import com.example.snacknbite.data.model.FoodGenre

@Composable
fun FoodCard(food: FoodGenre, modifier: Modifier = Modifier) {
    // Box/Column als Card-Ersatz
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(20.dp)
            )
            .border(
                BorderStroke(1.dp, Color.LightGray),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(12.dp)
    ) {
        // Bild
        Image(
            painter = painterResource(id = food.imgRes),
            contentDescription = food.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Name
        BasicText(
            text = food.name,
            style = TextStyle(
                fontSize = 22.sp,
                color = Color.Black,
                fontFamily = FontFamily.SansSerif
            )
        )

        // Theme
        BasicText(
            text = food.theme,
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Gray,
                fontFamily = FontFamily.SansSerif
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Beschreibung
        BasicText(
            text = food.description,
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.DarkGray,
                fontFamily = FontFamily.SansSerif
            )
        )
    }
}
