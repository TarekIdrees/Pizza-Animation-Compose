package com.example.pizzaanimation.viewmodel

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
        getPizzaSizes()
        getPizzaBreads()
        getIngredients()
    }

    private fun getIngredients() {
        _state.update {
            it.copy(
                ingredients = listOf(
                    Ingredient("basil", R.drawable.basil_3, isSelected = false),
                    Ingredient("onion", R.drawable.onion_3, isSelected = false),
                    Ingredient("onion", R.drawable.broccoli_3, isSelected = false),
                    Ingredient("mushroom", R.drawable.mushroom_3, isSelected = false),
                    Ingredient("sausage", R.drawable.sausage_3, isSelected = false),
                    Ingredient("basil", R.drawable.basil_3, isSelected = false),
                    Ingredient("onion", R.drawable.onion_3, isSelected = false),
                    Ingredient("onion", R.drawable.broccoli_3, isSelected = false),
                ),
            )
        }
    }

    private fun getPizzaBreads() {
        _state.update {
            it.copy(
                pizzaBreads = listOf(
                    Pizza(R.drawable.bread_1, _state.value.pizzaSize, emptyList()),
                    Pizza(R.drawable.bread_2, _state.value.pizzaSize, emptyList()),
                    Pizza(R.drawable.bread_3, _state.value.pizzaSize, emptyList()),
                    Pizza(R.drawable.bread_4, _state.value.pizzaSize, emptyList()),
                    Pizza(R.drawable.bread_5, _state.value.pizzaSize, emptyList()),
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

    override fun onClickIngredient(ingredient: Ingredient) {
        TODO("Not yet implemented")
    }

}