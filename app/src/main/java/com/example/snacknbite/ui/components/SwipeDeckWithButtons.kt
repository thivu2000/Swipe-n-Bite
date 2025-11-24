package com.example.snacknbite.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.key
import com.example.snacknbite.data.model.FoodGenre
import com.example.snacknbite.ui.screens.CompletionScreen

@Composable
fun SwipeDeckWithButtons(
    foods: List<FoodGenre>,
    modifier: Modifier = Modifier
) {
    var foodList by remember { mutableStateOf(foods) }
    var likedFoods by remember { mutableStateOf(emptyList<FoodGenre>()) }
    var dislikedFoods by remember { mutableStateOf(emptyList<FoodGenre>()) }
    var lastRemoved by remember { mutableStateOf<FoodGenre?>(null) }
    var lastAction by remember { mutableStateOf<String?>(null) }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        val visible = foodList.take(3)
        if (visible.isNotEmpty()) {
            val rev = visible.reversed()
            val size = rev.size
            rev.forEachIndexed { index, food ->
                val isTop = index == size - 1
                key(food.slug) {
                    if (isTop) {
                        SwipeableFoodCard(
                            food = food,
                            isTop = true,
                            onSwiped = { liked ->
                                lastRemoved = food
                                lastAction = if (liked) "Like" else "Dislike"
                                if (liked) likedFoods = likedFoods + food else dislikedFoods =
                                    dislikedFoods + food
                                foodList = foodList.filterNot { it.slug == food.slug }
                            }
                        )
                    } else {
                        FoodCard(food = food, modifier = Modifier.padding(16.dp))
                    }
                }
            }
        } else {
            CompletionScreen(
                likedCount = likedFoods.size,
                dislikedCount = dislikedFoods.size
            ) {
                foodList = foods
                likedFoods = emptyList()
                dislikedFoods = emptyList()
                lastRemoved = null
                lastAction = null
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (lastAction != null) {
                Text(
                    text = if (lastAction == "Like") "Gefällt mir!" else "Nicht mein Geschmack"
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                SwipeActionButton(text = "↩Zurück") {
                    lastRemoved?.let { f ->
                        foodList = listOf(f) + foodList
                        likedFoods = likedFoods - f
                        dislikedFoods = dislikedFoods - f
                        lastRemoved = null
                        lastAction = null
                    }
                }

                SwipeActionButton(text = "Nein") {
                    val current = foodList.firstOrNull() ?: return@SwipeActionButton
                    lastRemoved = current
                    lastAction = "Dislike"
                    dislikedFoods = dislikedFoods + current
                    foodList = foodList.filterNot { it.slug == current.slug }
                }

                SwipeActionButton(text = "✅ Ja") {
                    val current = foodList.firstOrNull() ?: return@SwipeActionButton
                    lastRemoved = current
                    lastAction = "Like"
                    likedFoods = likedFoods + current
                    foodList = foodList.filterNot { it.slug == current.slug }
                }
            }
        }
    }
}
