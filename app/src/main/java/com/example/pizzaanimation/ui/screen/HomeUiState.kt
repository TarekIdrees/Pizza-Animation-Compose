package com.example.pizzaanimation.ui.screen

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class HomeUiState(
    val cost: String = "17",
    val pizzaBreads: List<Pizza> = emptyList(),
    val ingredients: List<Ingredient> = emptyList(),
    val pizzaSizes: List<PizzaSize> = emptyList(),
    val selectedIngredients: List<Ingredient> = emptyList(),
    val pizzaSize: PizzaSize = PizzaSize("", Sizes.Small,0.dp,false)
)

data class Ingredient(
    val name: String = "",
    val position: Int = 0,
    val image: Int = 0,
    val icon: Int = 0,
    val isSelected: Boolean = false
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
    val pizzaIngredient: List<Ingredient>,
)