package com.example.snacknbite.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.snacknbite.data.model.FoodGenre
import com.example.snacknbite.ui.components.SwipeDeckWithButtons
import com.example.snacknbite.ui.theme.SnackNBiteTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(foodList: List<FoodGenre>) {
    SnackNBiteTheme {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("Snack n' Bite") },
                )
            }
        ) { innerPadding ->
            SwipeDeckWithButtons(
                foods = foodList,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )
        }
    }
}
