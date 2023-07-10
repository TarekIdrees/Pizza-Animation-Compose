package com.example.pizzaanimation.viewmodel

data class HomeUiState(
    val cost: String = "17",
    val pizzaBreads: List<Int> = emptyList(),
    val ingredients: List<Ingredient> = emptyList(),
    val pizzaSizes: List<PizzaSize> = emptyList(),
)
data class Ingredient(
    val name: String,
    val image: Int
)
data class PizzaSize(
    val name: String,
    val isSelected: Boolean
)