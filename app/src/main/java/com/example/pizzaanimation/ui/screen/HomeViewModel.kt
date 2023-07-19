package com.example.pizzaanimation.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.pizzaanimation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel(), HomeInteractionListener {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getPizzaSize()
        getIngredients()
        getPizzaSizes()
        getPizzaBreads()
    }

    private fun getIngredients() {
        _state.update {
            it.copy(
                ingredients = listOf(
                    Ingredient(
                        "basil",
                        0,
                        R.drawable.image_basil,
                        R.drawable.basil_3,
                        isSelected = false
                    ),
                    Ingredient(
                        "onion",
                        1,
                        R.drawable.image_onion,
                        R.drawable.onion_3,
                        isSelected = false
                    ),
                    Ingredient(
                        "broccoli",
                        2,
                        R.drawable.image_broccoli,
                        R.drawable.broccoli_3,
                        isSelected = false
                    ),
                    Ingredient(
                        "mushroom",
                        3,
                        R.drawable.image_mushroom,
                        R.drawable.mushroom_3,
                        isSelected = false
                    ),
                    Ingredient(
                        "sausage",
                        4,
                        R.drawable.image_sausage,
                        R.drawable.sausage_3,
                        isSelected = false
                    ),
                ),
            )
        }
    }

    private fun getPizzaBreads() {
        _state.update {
            it.copy(
                pizzaBreads = listOf(
                    Pizza(R.drawable.bread_1, _state.value.pizzaSize, _state.value.ingredients),
                    Pizza(R.drawable.bread_2, _state.value.pizzaSize, _state.value.ingredients),
                    Pizza(R.drawable.bread_3, _state.value.pizzaSize, _state.value.ingredients),
                    Pizza(R.drawable.bread_4, _state.value.pizzaSize, _state.value.ingredients),
                    Pizza(R.drawable.bread_5, _state.value.pizzaSize, _state.value.ingredients),
                )
            )
        }
    }

    private fun getPizzaSizes() {
        _state.update {
            it.copy(
                pizzaSizes = listOf(
                    PizzaSize("S", Sizes.Small, 150.dp, false),
                    PizzaSize("M", Sizes.Medium, 200.dp, false),
                    PizzaSize("L", Sizes.Large, 225.dp, false)
                )
            )
        }
    }

    private fun getPizzaSize() {
        _state.update {
            it.copy(
                pizzaSize = PizzaSize("S", Sizes.Small, 150.dp, false)
            )
        }
    }

    override fun onClickSize(size: PizzaSize) {
        _state.update { it.copy(pizzaSize = size) }
    }

    @ExperimentalFoundationApi
    override fun onClickIngredient(ingredientPosition: Int, pizzaPosition: Int) {
        val currentUiState = _state.value
        val updatedPizzaIngredient =
            currentUiState.pizzaBreads[pizzaPosition].pizzaIngredient.mapIndexed { index, pizzaIngredient ->
                if (index == ingredientPosition) {
                    pizzaIngredient.copy(isSelected = !pizzaIngredient.isSelected)
                } else {
                    pizzaIngredient
                }
            }
        val updatedPizzaBreads = currentUiState.pizzaBreads.mapIndexed { index, pizzaBread ->
            if (index == pizzaPosition) {
                pizzaBread.copy(pizzaIngredient = updatedPizzaIngredient)
            } else {
                pizzaBread
            }
        }
        val updatedUiState = currentUiState.copy(pizzaBreads = updatedPizzaBreads)
        _state.value = updatedUiState
    }
}