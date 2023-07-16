package com.example.pizzaanimation.ui.screen.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizzaanimation.ui.screen.HomeUiState
import com.example.pizzaanimation.ui.screen.Ingredient
import com.example.pizzaanimation.ui.theme.GreenLight

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IngredientChip(
    state: HomeUiState,
    ingredient: Ingredient,
    onClickIngredient: (Ingredient) -> Unit
) {
    if (state.selectedIngredients.contains(ingredient)) {
        Image(
            modifier = Modifier
                .size(70.dp)
                .padding(8.dp)
                .drawBehind {
                    drawCircle(
                        color = GreenLight,
                        radius = 130f
                    )
                }
                .clickable {
                    onClickIngredient(ingredient)
                },
            painter = painterResource(id = ingredient.image),
            contentScale = ContentScale.Fit,
            contentDescription = "character image",
        )
    } else {
        Image(
            modifier = Modifier
                .size(70.dp)
                .padding(8.dp)
                .clickable {
                    onClickIngredient(ingredient)
                },
            painter = painterResource(id = ingredient.image),
            contentScale = ContentScale.Fit,
            contentDescription = "character image",
        )
    }
}