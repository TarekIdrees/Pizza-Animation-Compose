package com.example.pizzaanimation.viewmodel

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class HomeUiState(
    val cost: String = "17",
    val pizzaBreads: List<Pizza> = emptyList(),
    val ingredients: List<Ingredient> = emptyList(),
    val pizzaSizes: List<PizzaSize> = emptyList(),
    val pizzaSize: PizzaSize = PizzaSize("", Sizes.Small,0.dp,false)
)

data class Ingredient(
    val name: String,
    val image: Int,
    val isSelected: Boolean
)

enum class Sizes{
    Small,
    Medium,
    Large
}
data class PizzaSize(
    val name: String,
    val type: Sizes,
    val size: Dp,
    val isSelected: Boolean
)

data class Pizza(
    val image: Int,
    val pizzaSize: PizzaSize,
    val ingredient: List<Ingredient>,
)