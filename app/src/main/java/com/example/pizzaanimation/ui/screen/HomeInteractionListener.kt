package com.example.pizzaanimation.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi

interface HomeInteractionListener {
    fun onClickSize(size: PizzaSize)
    @OptIn(ExperimentalFoundationApi::class)
    fun onClickIngredient(ingredient: Ingredient)

}