package com.example.snacknbite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.snacknbite.data.FoodData
import com.example.snacknbite.ui.AppScaffold
import com.example.snacknbite.ui.theme.SnackNBiteTheme

class

MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SnackNBiteTheme {
                AppScaffold(
                    foodList = FoodData.foods
                )
            }
        }
    }

    fun newFunction() {
    }
}
