package com.example.snacknbite.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SwipeActionButton(text: String, onClick: () -> Unit) {
    Button(onClick = onClick) { Text(text) }
}
