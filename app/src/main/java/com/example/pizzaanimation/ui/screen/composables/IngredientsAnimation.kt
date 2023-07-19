package com.example.pizzaanimation.ui.screen.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.pizzaanimation.ui.screen.Ingredient

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun IngredientsAnimation(state: Ingredient) {
    AnimatedVisibility(
        visible = state.isSelected,
        enter = scaleIn(initialScale = 3f) + fadeIn(),
        exit = fadeOut()
    ) {
        Image(
            painter = painterResource(id = state.image),
            contentDescription = "Ingredient",
        )
    }
}