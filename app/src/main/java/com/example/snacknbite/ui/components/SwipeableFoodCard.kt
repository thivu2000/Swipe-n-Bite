package com.example.snacknbite.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.zIndex
import com.example.snacknbite.data.model.FoodGenre
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

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
            .zIndex(if (isTop) 100f else 0f)
            .pointerInput(isTop) {
                if (isTop) {
                    detectDragGestures(
                        onDragEnd = {
                            scope.launch {
                                when {
                                    offsetX.value > swipeThreshold -> {
                                        offsetX.animateTo(screenWidthPx * 1.5f, tween(300))
                                        onSwiped(true)
                                    }
                                    offsetX.value < -swipeThreshold -> {
                                        offsetX.animateTo(-screenWidthPx * 1.5f, tween(300))
                                        onSwiped(false)
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
        if (isTop) {
            if (offsetX.value > 50f) {
                Text(
                    text = "LIKE",
                    color = Color(0xFF2E7D32),
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp)
                        .graphicsLayer { alpha = (offsetX.value / 250f).coerceIn(0f, 1f) }
                )
            } else if (offsetX.value < -50f) {
                Text(
                    text = "NOPE",
                    color = Color(0xFFB00020),
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                        .graphicsLayer { alpha = (-offsetX.value / 250f).coerceIn(0f, 1f) }
                )
            }
        }
    }
}
