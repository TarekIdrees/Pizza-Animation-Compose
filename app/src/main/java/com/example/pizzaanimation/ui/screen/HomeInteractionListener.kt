package com.example.pizzaanimation.ui.screen


interface HomeInteractionListener {
    fun onClickSize(size: PizzaSize)
    fun onClickIngredient(ingredientPosition: Int, pizzaPosition: Int)

}