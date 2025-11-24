package com.example.snacknbite.ui.screens

import androidx.compose.runtime.Composable
import com.example.snacknbite.data.model.FoodGenre
import com.example.snacknbite.ui.components.SwipeDeckWithButtons

@Composable
fun SwipeDeckScreen(foodList: List<FoodGenre>) {
    SwipeDeckWithButtons(foods = foodList)
}
