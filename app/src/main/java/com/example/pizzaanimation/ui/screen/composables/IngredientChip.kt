package com.example.pizzaanimation.ui.screen.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizzaanimation.ui.screen.Ingredient
import com.example.pizzaanimation.ui.theme.GreenLight

@Composable
fun IngredientChip(
    ingredient: Ingredient,
    isSelected: Boolean,
    onClickIngredient: (id: Int) -> Unit
) {
    Image(
        modifier = Modifier
            .size(70.dp)
            .padding(8.dp)
            .clip(CircleShape)
            .background(
                if (isSelected) GreenLight else Color.Transparent
            )
            .clickable {
                onClickIngredient(ingredient.position)
            },
        painter = painterResource(id = ingredient.icon),
        contentScale = ContentScale.Fit,
        contentDescription = "character image",
    )
}