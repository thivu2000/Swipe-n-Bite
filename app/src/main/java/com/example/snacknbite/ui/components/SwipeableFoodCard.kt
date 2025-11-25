package com.example.snacknbite.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import kotlinx.coroutines.launch
import kotlin.math.roundToInt
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.foundation.text.BasicText
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.snacknbite.data.model.FoodGenre

@Composable
fun SwipeableFoodCard(
    food: FoodGenre,
    isTop: Boolean,
    onSwiped: (liked: Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val offsetX = remember { Animatable(0f) }
    val offsetY = remember { Animatable(0f) }
    val swipeThreshold = with(LocalDensity.current) { 150.dp.toPx() }
    val screenWidthPx = with(LocalDensity.current) { LocalConfiguration.current.screenWidthDp.dp.toPx() }

    Box(
        modifier = modifier
            .fillMaxWidth(0.9f)
            .height(420.dp)
            .offset { IntOffset(offsetX.value.roundToInt(), offsetY.value.roundToInt()) }
            .graphicsLayer { rotationZ = (offsetX.value / 20).coerceIn(-20f, 20f) }
            .pointerInput(isTop) {
                if (isTop) {
                    detectDragGestures(
                        onDragEnd = {
                            scope.launch {
                                when {
                                    offsetX.value > swipeThreshold -> {
                                        offsetX.animateTo(screenWidthPx * 1.5f, tween(300))
                                        onSwiped(true)
                                        offsetX.snapTo(0f)
                                        offsetY.snapTo(0f)
                                    }
                                    offsetX.value < -swipeThreshold -> {
                                        offsetX.animateTo(-screenWidthPx * 1.5f, tween(300))
                                        onSwiped(false)
                                        offsetX.snapTo(0f)
                                        offsetY.snapTo(0f)
                                    }
                                    else -> {
                                        offsetX.animateTo(0f, tween(300))
                                        offsetY.animateTo(0f, tween(300))
                                    }
                                }
                            }
                        }
                    ) { change, dragAmount ->
                        change.consume()
                        scope.launch {
                            offsetX.snapTo(offsetX.value + dragAmount.x)
                            offsetY.snapTo(offsetY.value + dragAmount.y)
                        }
                    }
                }
            }
    ) {
        FoodCard(food = food)

        // LIKE / NOPE Anzeige
        if (offsetX.value > 50f) {
            BasicText(
                text = "LIKE",
                style = TextStyle(
                    color = Color(0xFF2E7D32),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier
                    .padding(16.dp)
            )
        } else if (offsetX.value < -50f) {
            BasicText(
                text = "DISLIKE",
                style = TextStyle(
                    color = Color(0xFFB00020),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}
