package com.example.pizzaanimation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pizzaanimation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getPizzaBreads()
        getPizzaSizes()
        getIngredients()
    }

    private fun getIngredients() {
        _state.update {
            it.copy(
                ingredients = listOf(
                    Ingredient("basil", R.drawable.basil_3),
                    Ingredient("onion", R.drawable.onion_3),
                    Ingredient("onion", R.drawable.broccoli_3),
                    Ingredient("mushroom", R.drawable.mushroom_3),
                    Ingredient("sausage", R.drawable.sausage_3),
                    Ingredient("basil", R.drawable.basil_3),
                    Ingredient("onion", R.drawable.onion_3),
                    Ingredient("onion", R.drawable.broccoli_3),
                ),
            )
        }
    }

    private fun getPizzaBreads() {
        _state.update {
            it.copy(
                pizzaBreads = listOf(
                    R.drawable.bread_1,
                    R.drawable.bread_2,
                    R.drawable.bread_3,
                    R.drawable.bread_4,
                    R.drawable.bread_5,
                )
            )
        }
    }

    private fun getPizzaSizes() {
        _state.update {
            it.copy(
                pizzaSizes = listOf(
                    PizzaSize(
                        "S",
                        false,
                    ),
                    PizzaSize(
                        "M",
                        false,
                    ),
                    PizzaSize(
                        "L",
                        false,
                    ),
                )
            )
        }
    }
}