package com.example.pizzaanimation.viewmodel

interface HomeInteractionListener {
    fun onClickSize(size: PizzaSize)
    fun onClickIngredient(ingredient: Ingredient)
}