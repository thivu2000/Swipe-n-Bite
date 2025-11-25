package com.example.snacknbite.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.zIndex
import com.example.snacknbite.data.model.FoodGenre
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun SwipeDeckWithButtons(
    foods: List<FoodGenre>,
    modifier: Modifier = Modifier
) {
    var currentIndex by remember { mutableStateOf(0) }
    var likedCount by remember { mutableStateOf(0) }
    var dislikedCount by remember { mutableStateOf(0) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Zähler oben anzeigen
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BasicText(
                text = "Likes: $likedCount",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Green,
                    fontWeight = FontWeight.Bold
                )
            )
            BasicText(
                text = "Dislikes: $dislikedCount",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Karte
        if (currentIndex < foods.size) {
            SwipeableFoodCard(
                food = foods[currentIndex],
                isTop = true,
                onSwiped = { liked ->
                    if (liked) likedCount++ else dislikedCount++
                    currentIndex++
                }
            )
        } else {
            // Fertig-Bildschirm
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                BasicText(
                    text = "Fertig!",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color(0xFF6200EE),
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(12.dp))
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
                ActionButton("Neu starten") {
                    currentIndex = 0
                    likedCount = 0
                    dislikedCount = 0
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Buttons: Like – Zurück – Dislike
        if (currentIndex < foods.size) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ActionButton("Like") {
                    likedCount++
                    currentIndex++
                }
                ActionButton("Zurück") {
                    if (currentIndex > 0) currentIndex--
                }
                ActionButton("Dislike") {
                    dislikedCount++
                    currentIndex++
                }
            }
        }
    }
}

@Composable
fun ActionButton(text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .background(Color(0xFF03DAC5), RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .padding(horizontal = 18.dp, vertical = 12.dp)
    ) {
        BasicText(
            text = text,
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black
            )
        )
    }
}