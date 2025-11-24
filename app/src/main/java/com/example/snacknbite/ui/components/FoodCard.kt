package com.example.snacknbite.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.snacknbite.data.model.FoodGenre

@Composable
fun FoodCard(food: FoodGenre, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {

            Image(
                painter = painterResource(id = food.imgRes),
                contentDescription = food.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )

            Spacer(Modifier.height(12.dp))
            Text(food.name, style = MaterialTheme.typography.headlineSmall)
            Text(food.theme, style = MaterialTheme.typography.labelMedium)
            Spacer(Modifier.height(8.dp))
            Text(food.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
