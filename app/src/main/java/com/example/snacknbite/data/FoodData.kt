package com.example.snacknbite.data
import com.example.snacknbite.R
import com.example.snacknbite.data.model.FoodGenre

object FoodData {

    val foods = listOf(
        FoodGenre(
            name = "Pizza",
            slug = "pizza",
            imgRes = R.drawable.pizza,
            description = "Frisch gebackene Pizza mit knusprigem Boden.",
            theme = "Italienisch"
        ),
        FoodGenre(
            name = "Burger",
            slug = "burger",
            imgRes = R.drawable.burger,
            description = "Saftiger Rindfleisch-Burger mit knackigem Gemüse.",
            theme = "Amerikanisch"
        ),
        FoodGenre(
            name = "Sushi",
            slug = "sushi",
            imgRes = R.drawable.sushi,
            description = "Traditionelles Sushi mit frischem Fisch.",
            theme = "Japanisch"
        ),
        FoodGenre(
            name = "Pasta",
            slug = "pasta",
            imgRes = R.drawable.pasta,
            description = "Cremige Pasta mit Kräutern und Käse.",
            theme = "Italienisch"
        ),
        FoodGenre(
            name = "Tacos",
            slug = "tacos",
            imgRes = R.drawable.taco,
            description = "Würzige Tacos mit Gemüse und Fleisch.",
            theme = "Mexikanisch"
        )
    )
}
